package jdbc.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    private static Connection connection;

    static {
        try {
            connection = ConnectionPostgreSQL.getConnection("URL_DB_test", "USER", "PASSWORD");
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            exceptionParameterNotExist.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {

//        String createTable = "CREATE TABLE students(s_id integer PRIMARY KEY, name text, start_year integer);";
//        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
//        preparedStatement.executeUpdate();
//
//        String insertStydent = "INSERT INTO students(s_id, name, start_year) VALUES (521, 'Анна', 2014);";
//        PreparedStatement preparedStatement1 = connection.prepareStatement(insertStydent);
//        preparedStatement1.executeUpdate();

        String select = "SELECT * FROM students;";
        PreparedStatement preparedStatement2 = connection.prepareStatement(select);
        preparedStatement2.execute();
        ResultSet resultSet = preparedStatement2.getResultSet();
        while (resultSet.next()) {
            System.out.println("\n------------------\n");
            System.out.println("id = " + resultSet.getInt("s_id"));
            System.out.println("name = " + resultSet.getString("name"));
            System.out.println("start_year = " + resultSet.getInt("start_year"));
        }
        System.out.println("\n------------------\n");


    }
}
