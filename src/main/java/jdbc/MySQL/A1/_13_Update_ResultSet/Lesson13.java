package jdbc.MySQL.A1._13_Update_ResultSet;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson13 {
    public static void main(String[] args) {

        try {
            Statement statement = ConnectionMySQL.getConnection().createStatement();
            statement.execute("USE JDBC");
            statement.execute("DROP TABLE IF EXISTS Books");
            statement.executeUpdate("CREATE TABLE Books (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20))");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno'),('Solomon Key'),('Cod Davinchi'),                              ('Filosofia java'), ('Stryktyra dannux'), ('Libros de CEAC'), ('Mir i Voina'), ('Podoraz')");


            Statement statement1 = ConnectionMySQL.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

//            PreparedStatement preparedStatement = ConnectionMySQL.getConnection().prepareStatement(
//                    "sql comand", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM Books");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "  ");
                System.out.println(resultSet.getString("name"));
            }

            System.out.println("-------------------------------");

            resultSet.last();
            resultSet.updateString("name", "Update Libro");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "New Libro");
            resultSet.insertRow();

            resultSet.absolute(6);
            resultSet.deleteRow();


            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "  ");
                System.out.println(resultSet.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
