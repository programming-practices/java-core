package stringAPI._string;

public class ExampleStringCompareTo {
    public static void main(String[] args) {

        String str3 = "abc";
        String str4 = "ac";
        String str5 = "ab";
        String str6 = "abc";
        System.out.println("\"abc\".compareTo(\"ac\") -->  " + str3.compareTo(str4));
        System.out.println("\"abc\".compareTo(\"ab\") -->   " + str3.compareTo(str5));
        System.out.println("\"abc\".compareTo(\"abc\") -->  " + str3.compareTo(str6));
        // S chislami nado bit ostoroznim. Nado snachalo provirat a dlinu stroki esli stroki
        // ravnue po dline to sravnivat ix s compareTo(). A esli odna s strok menwe po dline
        // to srazy ee vevodit kak menwyy.
        System.out.println();
        System.out.println("\"1230\".compareTo(\"523\") -->  " + "1230".compareTo("523"));
        System.out.println("\"1230\".compareTo(\"5231\") -->  " + "1230".compareTo("5231"));

    }
}
