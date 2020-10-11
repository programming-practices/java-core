package jdbc.MySQL.A1._12_Scrollable_RowSet;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson12 {
    public static void main(String[] args) {

        try {
            Statement statement = ConnectionMySQL.getConnection().createStatement();
            statement.execute("USE JDBC");
//            statement.execute("DROP TABLE IF EXISTS Books");
//            statement.executeUpdate("CREATE TABLE Books (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20))");
//            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno'),('Solomon Key'),('Cod Davinchi'),                              ('Filosofia java'), ('Stryktyra dannux'), ('Libros de CEAC'), ('Mir i Voina'), ('Podoraz')");

            Statement statement1 = ConnectionMySQL.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//            PreparedStatement preparedStatement = ConnectionMySQL.getConnection().prepareStatement(
//                    "SQL comanda", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement1.executeQuery("SELECT * FROM Books");

            if (resultSet.next())
                System.out.println(resultSet.getString("name"));

            if (resultSet.next())
                System.out.println(resultSet.getString("name"));

            if (resultSet.next())
                System.out.println(resultSet.getString("name"));

            if (resultSet.previous())
                System.out.println(resultSet.getString("name"));   // Poiti v obratnyiy storony

            if (resultSet.relative(2))
                System.out.println(resultSet.getString("name"));    //  Naskolko kolonok nado sdvintsa
//
            if (resultSet.relative(-2))
                System.out.println(resultSet.getString("name"));
//
            if (resultSet.absolute(5))
                System.out.println(resultSet.getString("name"));    // nomer strochki na kotoryiy xotim pereiti
//
            if (resultSet.first())
                System.out.println(resultSet.getString("name"));

            if (resultSet.last())
                System.out.println(resultSet.getString("name"));

//            resultSet.beforeFirst();
//            resultSet.afterLast();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
