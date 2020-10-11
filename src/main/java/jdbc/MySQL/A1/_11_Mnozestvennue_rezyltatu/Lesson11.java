package jdbc.MySQL.A1._11_Mnozestvennue_rezyltatu;

import jdbc.MySQL.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson11 {
    public static void main(String[] args) {

        try {
            Statement statement = ConnectionMySQL.getConnection().createStatement();
            statement.execute("USE JDBC");
            statement.execute("DROP TABLE IF EXISTS Books");
            statement.executeUpdate("CREATE TABLE Books (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20))");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Solomon Key')");

            CallableStatement callableStatement = ConnectionMySQL.getConnection().prepareCall("{call getCount}");
            boolean hasResults = callableStatement.execute();
            while (hasResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
                hasResults = callableStatement.getMoreResults();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
