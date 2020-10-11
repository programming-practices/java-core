package jdbc.MySQL.A1._10_Xranimie_Procedyru;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson10 {
    public static void main(String[] args) {

        try {
            Statement statement = ConnectionMySQL.getConnection().createStatement();
            statement.execute("USE JDBC");
//            statement.execute("DROP TABLE IF EXISTS Books");
//            statement.executeUpdate("CREATE TABLE Books (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20))");
//            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')");
//            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Solomon Key')");

//            CallableStatement callableStatement = ConnectionMySQL.getConnection().prepareCall("{call BooksCount(?)}");
//            callableStatement.registerOutParameter(1, Types.INTEGER);
//            callableStatement.execute();
//            System.out.println(callableStatement.getInt(1));
//            System.out.println("----------------------------");


            CallableStatement callableStatement1 = ConnectionMySQL.getConnection().prepareCall("{call getBooks(?)}");
            callableStatement1.setInt(1, 1);
            if (callableStatement1.execute()) {
                ResultSet resultSet = callableStatement1.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }


//            statement.execute("DROP TABLE IF EXISTS Users");
//            statement.executeUpdate("CREATE TABLE Users (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20) NOT NULL , password CHAR (20) NOT NULL )");
//            statement.executeUpdate("INSERT INTO Users (name,password) VALUES ('Nicolas', 'en341oe1')");
//            statement.executeUpdate("INSERT INTO Users (name,password) VALUES ('Tomas', 'ev5n341oe1')");
//            statement.executeUpdate("INSERT INTO Users (name,password) VALUES ('Caren', 'ev03o1oe1')");
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
//            while (resultSet.next()){
//                System.out.println("IdBook = " + resultSet.getInt("id"));
//                System.out.println("NameBook = " + resultSet.getString("name"));
//                System.out.println("------------------------------------------------------------------------");
//            }
//            System.out.println("---------------------------------------------------------------------");
//            System.out.println("---------------------------------------------------------------------");
//            System.out.println("---------------------------------------------------------------------");
//
//            resultSet = statement.executeQuery("SELECT * FROM Users");
//            while (resultSet.next()){
//                System.out.println("IdUser = " + resultSet.getInt("id"));
//                System.out.println("NameUser = " + resultSet.getString("name"));
//                System.out.println("Password = " + resultSet.getString("password"));
//                System.out.println("------------------------------------------------------------------------");
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
