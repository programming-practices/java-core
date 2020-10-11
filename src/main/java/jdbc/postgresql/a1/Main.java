package jdbc.postgresql.a1;

import jdbc.postgresql.ConnectionPostgreSQL;
import jdbc.postgresql.ExceptionParameterNotExist;

import java.sql.*;
import java.util.Calendar;

public class Main {
    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id = ?";
    private static final String pathIcon = "src/main/resources/duke.gif";
    private static PreparedStatement preparedStatement = null;
    private static Connection connection;

    static {
        try {
            connection = ConnectionPostgreSQL.getConnection("", "", "");
        } catch (ExceptionParameterNotExist exceptionParameterNotExist) {
            exceptionParameterNotExist.printStackTrace();
        }
    }

    public static void main(String[] args) {
//------------------------------------------------ Statement ----------------------------------------------------------
////        String query = "SELECT * FROM users";
//        String query = "SELECT * FROM users WHERE id = 2";
//
//        try {
//            Statement statement = connectionDB.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()){
////                int id = resultSet.getInt("id");
////                System.out.println("id = " + id);
////                String username = resultSet.getString("username");
////                System.out.println("username = " + username);
////                String password = resultSet.getString("password");
////                System.out.println("password = " + password);
//                User user =  new User();
//                // mozna obrawchatsa k tablice s nomerom colonki ili s nazvaniem colonki
//                // lydwe ispolzovat obrawchenie k tablice po imeni, tak esli pomeniaetsa razmewchenie
//                // kolonok v tablich logika programu ne slomaetsa
//                user.setId(resultSet.getInt("id"));
//                user.setUserName(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                System.out.println(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//---------------------------------------------- PreparedStatement ----------------------------------------------------
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3, "Inserted description");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, (new Date(Calendar.getInstance().getTimeInMillis())));
//            preparedStatement.setBlob(7, new FileInputStream(pathIcon));
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date created = resultSet.getDate("created");
//                byte [] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id + "\ntitle: " + title +
                        "\ndescription: " + description + "\nrating: " + rating +
                        "\npublished: " + published + "\ncrested: " + created /*+
                        "\nicon: " + icon.length*/);
            }

            // udalenie iz tablicu
            preparedStatement = connection.prepareStatement(DELETE);
//            preparedStatement.setInt(1,2);
//            preparedStatement.executeUpdate();
//            preparedStatement.setInt(1,3);
//            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, 4);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            try {
                preparedStatement.close();
                ConnectionPostgreSQL.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}
