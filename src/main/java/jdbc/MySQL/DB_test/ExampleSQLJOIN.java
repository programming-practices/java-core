package jdbc.MySQL.DB_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Iatochnik etoho video: https://www.youtube.com/watch?v=EHvzvwAv7RU
public class ExampleSQLJOIN {
    // Etot zapros ochen ploxoi so storonu proizvoditelnosti
    // Etot zapros rabotaet korectno, no on delaet mnoho robotu on snachalo obedinaet tablicu a potom delaet WHERE sravnenie.
    /* Toest bydet tak
        1   AA
        1   BB
        1   EE
        1   FF
        2   AA
        2   BB
        2   EE
    i tak dalie, i tolko posle etoho bydet proisxodit filtrovanie s pomoshchy slova WHERE */
    private static final String QUERY1 = "SELECT * FROM table_1, table_2 WHERE table_1.key1 = table_2.key2";

    // Totze vuvod obedinonux tablic, no netu takix bolwux zatrat na rewenie zaprosa
    // INNER JOIN vuburaet iz tablic table_1 i table_2 te zapisi cotorue sovpadat
    private static final String QUERY2 = "SELECT data1, data2 FROM table_1 INNER JOIN table_2 ON table_1.key1 = table_2.key2";

    // LEFT JOIN vibiraet s levoi tablicu table_1 vse znachenia a s pravoi tolko te znachenia chto proxodiat sravnenie
    // pystue mesta zapolniaytsa NULL
    private static final String QUERY3 = "SELECT data1, data2 FROM table_1 LEFT JOIN table_2 ON table_1.key1 = table_2.key2";

    // RIGHT JOIN vuberaet s levoi tolko te znachenia chto proxodiat sravnenie pystue mesta zapolniaytsa NULL, a s pravoi
    // storonu vubiraytsa vse znachenia tablicu.
    private static final String QUERY4 = "SELECT data1, data2 FROM table_1 RIGHT JOIN table_2 ON table_1.key1 = table_2.key2";

    // FULL JOIN soidinaet vse resultatu
    private static final String QUERY5 = "SELECT data1, data2 FROM table_1 FULL JOIN table_2 ON table_1.key1 = table_2.key2";
    private static final String QUERY6 = "SELECT data1, data2 FROM table_1 FULL JOIN table_2 ";
    private static final String QUERY7 = "SELECT data1, data2 FROM table_1 FULL JOIN table_2  ON key1 = key2";

    // Esli v database ne podderzyetsa FULL JOIN, to mozno zdelat tot ze samui resultat chto delaet FULL JOIN s pomoschy UNION
    private static final String QUERY8 = "SELECT data1, data2 FROM table_1 LEFT JOIN table_2 ON table_1.key1 = table_2.key2 " +
            "UNION ALL SELECT data1, data2 FROM table_1 RIGHT JOIN table_2 ON table_1.key1 = table_2.key2 WHERE data1 IS NULL ";


    public static void main(String[] args) {
        try {
            Statement statement = ConnectionMySQL_Test.getConnection().createStatement();
//            statement.execute("CREATE TABLE table_1(key1 INT, data1 VARCHAR (10))");
//            statement.execute("CREATE TABLE table_2(key2 INT, data2 VARCHAR (10))");
//            statement.execute("INSERT INTO table_1 VALUES (1, 'A')");
//            statement.execute("INSERT INTO table_1 VALUES (2, 'B')");
//            statement.execute("INSERT INTO table_1 VALUES (3, 'C')");
//            statement.execute("INSERT INTO table_1 VALUES (4, 'D')");

//            statement.execute("INSERT INTO table_2 VALUES (1, 'AA')");
//            statement.execute("INSERT INTO table_2 VALUES ( 2, 'BB')");
//            statement.execute("INSERT INTO table_2 VALUES (5, 'EE')");
//            statement.execute("INSERT INTO table_2 VALUES (6, 'FF')");

            ResultSet resultSet = statement.executeQuery(QUERY5);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println("-------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
