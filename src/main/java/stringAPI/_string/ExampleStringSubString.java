package stringAPI._string;

// Substring replacement.
public class ExampleStringSubString {
    public static void main(String args[]) {
// ---------------------------------------------------------------------------------------------------------------------
        String org = "This is age test. This is, too.";
        String search = "is";
        String sub = "was";
        String result = "";
        int i;

        do { // replace all matching substrings
//            System.out.println(org);
            i = org.indexOf(search);
            if (i != -1) {
                result = org.substring(0, i);
                result = result + sub;
                result = result + org.substring(i + search.length());
                org = result;
            }
        } while (i != -1);
// ---------------------------------------------------------------------------------------------------------------------
        System.out.println("Hello!".substring(0, 6));
        System.out.println("Hello!".substring(0, 5));
        System.out.println("Hello!".substring(0, 4));
        System.out.println("Hello!".substring(0, 3));
        System.out.println();
        System.out.println("Hello!".substring(0, 6));
        System.out.println("Hello!".substring(1, 6));
        System.out.println("Hello!".substring(2, 6));
        System.out.println("Hello!".substring(3, 6));
        System.out.println();
        System.out.println("Hello!".substring(0, 6));
        System.out.println("Hello!".substring(1, 5));
        System.out.println("Hello!".substring(2, 4));
        System.out.println("Hello!".substring(3, 3));
// ---------------------------------------------------------------------------------------------------------------------

    }
}
