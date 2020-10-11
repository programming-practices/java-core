package dataType;

/**
 * This information may be fake, need to verify this information.
 * <p>
 * Link sources of information:
 * <p>
 * 1. https://www.google.com/search?newwindow=1&safe=active&ei=iJh2XLjKEcCHjLsPkaO7qA0&q=Data+Types+Pool+in+java&oq=Data+Types+Pool+in+java&gs_l=psy-ab.12...4232.5535..7877...0.0..0.146.1039.4j6......0....1..gws-wiz.......0i71j35i304i39.YrKLtB7n6q4
 * 2. https://stackoverflow.com/questions/16737078/do-we-have-pools-for-all-primitive-types-in-permgen-area-of-heap
 * 3. https://stackoverflow.com/questions/14402794/object-pool-for-java-wrappers-and-string
 * 4. ...
 */
public class DataTypesPool {
    public static void main(String[] args) {

//======================================================================================================================
//======================================== Not Primitive Data Types Pool ===============================================
//======================================================================================================================

        String s1 = "Hello";
        String s2 = "Hello";
//        System.out.println(s1 == s2);      // Output -> true

        String s3 = "Hellogdsfgsdfgdsfgfffffffff" +
                "fddddddddddddddddddddddddddddddddddddddddddddd" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
        String s4 = "Hellogdsfgsdfgdsfgfffffffff" +
                "fddddddddddddddddddddddddddddddddddddddddddddd" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
                "dddddddddddddddffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
//        System.out.println(s3 == s4);       // Output -> true

//======================================================================================================================
//========================================== Primitive Data Types Pool =================================================
//======================================================================================================================

        long l1 = 126L;
        long l2 = 126L;

        long l3 = 200L;
        long l4 = 200L;

//        System.out.println(l1 == l2);       // Output -> true
//        System.out.println(l3 == l4);       // Output -> true

        double l5 = 126.0;
        double l6 = 126.0;

        double l7 = 200.0;
        double l8 = 200.0;

//        System.out.println(l5 == l6);       // Output -> true
//        System.out.println(l7 == l8);       // Output -> true

        float l9 = 126.0f;
        float l10 = 126.0f;

        float l11 = 200.0f;
        float l12 = 200.0f;

//        System.out.println(l9 == l10);       // Output -> true
//        System.out.println(l11 == l12);       // Output -> true

        short l13 = 126;
        short l14 = 126;

        short l15 = 200;
        short l16 = 200;

        System.out.println(l13 == l14);       // Output -> true
        System.out.println(l15 == l16);       // Output -> true
    }
}
