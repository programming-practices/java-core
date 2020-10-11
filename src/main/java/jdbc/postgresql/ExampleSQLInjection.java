package jdbc.postgresql;

import java.sql.*;

public class ExampleSQLInjection {

    private final static String queryCreateTable =
            "CREATE TABLE users (id integer PRIMARY KEY NOT NULL, " +
                    "name text NOT NULL, " +
                    "password text NOT NULL)";
    private final static String querySetData = "INSERT INTO users(id, name, password) VALUES " +
            "(1, 'Paloma', 'passwordPaloma'), " +
            "(2, 'Paula', 'passwordPaula')," +
            "(3, 'Peter', 'passwordPeter')";
    private final static String userID = "2";
    // This is SQLInjection "1' or 1 = '1"
//    private final static String userID = "1' or 1 = '1";
    private final static String querySelect = "SELECT * FROM users WHERE id = '" + userID + "'";
    // ostorzno zes  WHERE id = ?::integer , v postgresql tak oboznachaetsa a v
    // mysql prosto znak voprosa
    private final static String querySelect2 = "SELECT * FROM users WHERE id = ?::integer ";
    private final static String querySelect3 = "SELECT * FROM users";
    private final static String queryDropTable = "DROP TABLE users";
    private static Connection DB_CONNECTION;
    private static PreparedStatement preparedStatement = null;
    private static Statement statement = null;

    static {
        try {
            DB_CONNECTION = ConnectionPostgreSQL.getConnection("", "", "");
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            exceptionParameterNotExist.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            //------------------------Statement-----------------------------------
            //Statement ne protege de SQLInjection
            statement = DB_CONNECTION.createStatement();
            statement.execute(queryDropTable);
            statement.executeUpdate(queryCreateTable);
            statement.executeUpdate(querySetData);
//            ResultSet resultSet = statement.executeQuery(querySelect);
//            while (resultSet.next()) {
//                System.out.println("id = " + resultSet.getString(1));
//                System.out.println("name = " + resultSet.getString(2));
//                System.out.println("password = " + resultSet.getString(3));
//            }

            //----------------------PrepareStatement------------------------------
            // Yze proveriaet sql zapros na SQLInjection
            preparedStatement = DB_CONNECTION.prepareStatement(querySelect2);
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString("name"));
                System.out.println("password = " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPostgreSQL.closeConnection();
        }

    }
}
