package jdbc.MySQL.A2._5_Lesson;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson5 {


    public static void main(String[] args) {

//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try (Connection con = ConnectionMySQL.getConnection();
             Statement statement = con.createStatement()) {

//            System.out.println(con.isClosed());

//            statement.execute("CREATE DATABASE devcolibri");
            statement.execute("USE devcolibri");
//            statement.execute("CREATE TABLE animal (id INT AUTO_INCREMENT PRIMARY KEY , animal_name CHAR(10), animal_desc CHAR(30))");
//            statement.execute("INSERT INTO animal VALUES (NULL , 'perro', 'ladra mucho')");
//            int quantityChanges = statement.executeUpdate("UPDATE animal SET animal_name = 'new name' WHERE id = 1");
//            System.out.println(quantityChanges);

//            ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
//            while (resultSet.next()){
//                System.out.println("id = " + resultSet.getInt("id"));
//                System.out.println("animal_name = " + resultSet.getString("animal_name"));
//                System.out.println("description_animal = " + resultSet.getString("animal_desc"));
//            }

//            statement.addBatch("INSERT INTO animal VALUES (NULL , 'perro', 'ladra mucho')");
//            statement.addBatch("INSERT INTO animal VALUES (NULL , 'cat', 'may')");
//            statement.addBatch("INSERT INTO animal VALUES (NULL , 'vaca', 'myy')");
//            statement.executeBatch();
//            statement.clearBatch();

            boolean statusConnectionisCoset = statement.isClosed();
            System.out.println(statusConnectionisCoset);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
