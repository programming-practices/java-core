package jdbc.MySQL.A1._7_Injection_i_PreparementStatement;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lesson7 {
    public static void main(String[] args) throws SQLException {

//        Statement statement = ConnectionMySQL.getConnection().createStatement();
//        ResultSet resultSet;
//        statement.execute("USE JDBC");
//        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users " +
//                "(id MEDIUMINT AUTO_INCREMENT PRIMARY KEY NOT NULL , " +
//                "name CHAR (30) NOT NULL, " +
//                "password CHAR (20) NOT NULL )");
//
//        statement.executeUpdate("INSERT INTO Users VALUES " +
//                "(NULL , 'Carlos', 'uroenva3-'), " +
//                "(NULL , 'Felix', 'passwortsdf2'), "+
//                "(NULL , 'Nacho', 'passwortsdf2')");

//        statement.executeUpdate("DELETE FROM Users WHERE  id = 5");
//        statement.executeUpdate("DELETE FROM Users WHERE  id = 6");
//        statement.executeUpdate("DELETE FROM Users WHERE  id = 7");

//        resultSet = statement.executeQuery("SELECT * FROM Users");

//        String userId = "8";
//        userId = "8 ' or 8 = '8";    // SQL Injection

//        resultSet = statement.executeQuery("SELECT * FROM Users WHERE id = '" + userId + "'");
//        resultSet = statement.executeQuery("SELECT * FROM Users");
//        while (resultSet.next()){
//            System.out.println("Id = " + resultSet.getInt("id"));
//            System.out.println("Name = " + resultSet.getString("name"));
//            System.out.println("Password = " + resultSet.getString("password"));
//            System.out.println("---------------------------------------------");
//        }


        //  Zawchita ot SQL Injection

        String userId = "8";
//        String userId = "8 ' or 8 = '8";    // SQL Injection

        PreparedStatement preparedStatement = ConnectionMySQL.getConnection().prepareStatement("SELECT * FROM Users WHERE id = ?");
        preparedStatement.execute("USE JDBC");
        preparedStatement.setString(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Id = " + resultSet.getInt("id"));
            System.out.println("Name = " + resultSet.getString("name"));
            System.out.println("Password = " + resultSet.getString("password"));
            System.out.println("---------------------------------------------");
        }

    }
}
