package db_data_base;

public class ExampleRelationalAlgebra {
    // ------------ CREATE TABLE t2 LIKE t ---------------
    private static final String sqlCreateTable = "CREATE TABLE t (id INT PRIMARY KEY, name VARCHAR(16), age INT)";
    // ------------ SET OPERATIONS -----------------------
    private static final String sqlInsertTable1 = "INSERT INTO t(id, name, age) VALUES(1, 'aaa', 10)";
    private static final String sqlInsertTable2 = "INSERT INTO t(id, name, age) VALUES(2, 'bbb', 20)";
    private static final String sqlInsertTable3 = "INSERT INTO t(id, name, age) VALUES(3, 'ccc', 30)";
    // ------------ UNION --------------------------------
//    private static final String sqlSelect = "SELECT * FROM (SELECT * FROM (SELECT * FROM t) AS x) AS x";

    public static void main(String[] args) {
//        try(PreparedStatement statement = ConnectionMySQL_Test.getConnection().prepareStatement(sqlSelect)) {
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
