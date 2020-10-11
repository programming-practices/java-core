package jdbc.MySQL.DB_sakila;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasDeTabla {
    private static final String QUERY = "SELECT title, description FROM film";
    private static final String QUERY2 = "SELECT title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating FROM film";
    private static final String QUERY3 = "SELECT * FROM film";
    private static final String QUERY4 = "SELECT description, title, rental_duration FROM film WHERE (rental_duration > 3)";
    private static final String QUERY5 = "SELECT description, title, rental_duration FROM film WHERE (rental_duration > 3) AND (rental_duration < 7)";
    private static final String QUERY6 = "SELECT description, title, rental_duration FROM film WHERE (rental_duration BETWEEN 5 AND 6)";
    private static final String QUERY7 = "SELECT * FROM film WHERE (rental_duration BETWEEN 5 AND 6) AND (length <= 70)";
    private static final String QUERY8 = "SELECT * FROM film WHERE (rental_duration BETWEEN 5 AND 6) AND (length BETWEEN 70 AND 80)";

    public static void main(String[] args) {
        try {
            Statement statement = ConnectionMySQL_Sakila.getConnection().createStatement();
            statement.execute("USE sakila");

            ResultSet resultSet = statement.executeQuery(QUERY8);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
                System.out.println(resultSet.getString("description"));
                System.out.println(resultSet.getDate("release_year"));
                System.out.println(resultSet.getInt("language_id"));
                System.out.println(resultSet.getInt("original_language_id"));
                System.out.println(resultSet.getInt("rental_duration"));
                System.out.println(resultSet.getFloat("rental_rate"));
                System.out.println(resultSet.getInt("length"));
                System.out.println(resultSet.getFloat("replacement_cost"));
                System.out.println(resultSet.getString("rating"));
                System.out.println(resultSet.getString("special_features"));
                System.out.println(resultSet.getTimestamp("last_update"));


                System.out.println("--------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
