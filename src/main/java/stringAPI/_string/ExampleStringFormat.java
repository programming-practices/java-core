package stringAPI._string;

public class ExampleStringFormat {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        String formatString = "We are printing double variable (%fArgInt), string ('%s') and integer variable (%d).";
//        System.out.println(String.format(formatString, 2.3, "habr", 10));
        // We are printing double variable (2.300000), string ('habr') and integer variable (10).
//--------------------------------------------------------------------------------------------------------------------
//        try {
//            throw new ClassA(3, 7, "Write failed");
//        } catch(Exception e) {
//            System.out.println(e);
//        }
//--------------------------------------------------------------------------------------------------------------------
        String sql = String.format(
                "SELECT id, country, city, street, post_code FROM address WHERE id = %d", new Long(34));
        System.out.println(sql);
//--------------------------------------------------------------------------------------------------------------------
    }
}

class ClassA extends Exception {

    public ClassA(int transactionID, int queryID, String message) {
        super(String.format("(transactionID%d, queryID%d) %s", transactionID, queryID, message));
    }

}
