package jdbc.MySQL.A1._14_Kewirovanie_rezultata_zaprosa_CachedRowSet;

import jdbc.MySQL.ConnectionMySQL;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson14 {

    public static void main(String[] args) throws SQLException, MalformedURLException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + "  ");
            System.out.println(resultSet.getString("name"));
        }

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        // ............

//        URL url = new URL(ConnectionMySQL.getURL());                    //   ERROR
////        URL url = new URL("jdbc:mysql://localhost:3306/JDBC?useSSL=FALSE");
//        cachedRowSet.setURL(1,url);
//        cachedRowSet.setUserName(ConnectionMySQL.getNAME());
//        cachedRowSet.setPassword(ConnectionMySQL.getPASSWORD());
//
//        cachedRowSet.setCommand("SELECT * FROM Books WHERE id = ?");
//        cachedRowSet.setInt(1,1);
//        cachedRowSet.setPageSize(20);
//        cachedRowSet.execute();
//
//        do {
//            while (cachedRowSet.next()){
//                System.out.print(cachedRowSet.getInt("id") + "  ");
//                System.out.println(cachedRowSet.getString("name"));
//            }
//        }while (cachedRowSet.nextPage());

        CachedRowSet cachedRowSet1 = (CachedRowSet) resultSet;
        cachedRowSet.setTableName("Books");
        cachedRowSet.absolute(1);
        cachedRowSet.deleteRow();
        cachedRowSet.beforeFirst();
        while (cachedRowSet1.next()) {
            System.out.print(cachedRowSet1.getInt("id") + "  ");
            System.out.println(cachedRowSet1.getString("name"));
        }
        cachedRowSet1.acceptChanges(DriverManager.getConnection(ConnectionMySQL.getURL(), ConnectionMySQL.getNAME(), ConnectionMySQL.getPASSWORD()));      // ERROR
//        cachedRowSet.setURL(1,url);
//        cachedRowSet.setUserName(ConnectionMySQL.getNAME());
//        cachedRowSet.setPassword(ConnectionMySQL.getPASSWORD());
//        cachedRowSet1.acceptChanges();
    }

    public static ResultSet getData() throws SQLException {
        try (Statement statement = ConnectionMySQL.getConnection().createStatement()) {
            statement.execute("USE JDBC");
            statement.execute("DROP TABLE IF EXISTS Books");
            statement.executeUpdate("CREATE TABLE Books (id MEDIUMINT AUTO_INCREMENT PRIMARY KEY , name CHAR (20))");
            statement.executeUpdate("INSERT  INTO Books (name) VALUES " + "('Inferno')", Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate("INSERT  INTO Books (name) VALUES " + "('Davinchi Code')", Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate("INSERT  INTO Books (name) VALUES " + "('Solomon Key')", Statement.RETURN_GENERATED_KEYS);

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            Statement statement1 = ConnectionMySQL.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement1.executeQuery("SELECT * FROM Books");
            cachedRowSet.populate(resultSet);
            return cachedRowSet;


        }
    }
}
