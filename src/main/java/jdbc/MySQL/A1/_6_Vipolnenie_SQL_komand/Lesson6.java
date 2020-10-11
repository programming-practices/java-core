package jdbc.MySQL.A1._6_Vipolnenie_SQL_komand;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.SQLException;
import java.sql.Statement;

public class Lesson6 {
    public static void main(String[] args) throws SQLException {

        Statement statement = ConnectionMySQL.getConnection().createStatement();

//        statement.execute("USE JDBC");
////        statement.execute("SELECT * FROM Books");
////        statement.execute("DROP TABLE Books");
//        statement.executeUpdate("CREATE TABLE Books " +
//                "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR (20) NOT NULL )");
//
//        statement.executeUpdate("INSERT INTO  Books VALUES (NULL , 'Inferno'), (NULL , 'Solomon Key')");
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
//
//        while (resultSet.next()) {
////            System.out.println(resultSet.getInt(1));
////            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getInt("id"));
//            System.out.println(resultSet.getString("name"));
//            System.out.println("---------------------------------------");
//        }
//
//
//        System.out.println(" Chek connect !!!!!!");
    }
}
