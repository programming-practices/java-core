package jdbc.MySQL.A1._9_Datu_i_SQL_posledovatelnosti;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson9 {
    public static void main(String[] args) throws SQLException {

        Statement statement = ConnectionMySQL.getConnection().createStatement();
        statement.execute("USE JDBC");
        statement.execute("DROP TABLE IF EXISTS Books");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                "Books (id MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY, name CHAR (25) NOT NULL, dt DATE )");

//        statement.execute("INSERT INTO Books VALUES (NULL ,'someName',new Date(1508519005097L))");

//        PreparedStatement preparedStatement = ConnectionMySQL.getConnection().prepareStatement(
//                "INSERT INTO Books (name, dt) VALUES ('someName',?)");
//
//        preparedStatement.execute("USE JDBC");
//        preparedStatement.setDate(1, new Date(1508526570508L));
//        preparedStatement.execute();
//        System.out.println(preparedStatement);

        statement.executeUpdate("INSERT INTO Books (name, dt) VALUES ('someName', {d'2017-10-20'})");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
        while (resultSet.next()) {
            System.out.println(resultSet.getDate("dt"));
        }

    }


}
