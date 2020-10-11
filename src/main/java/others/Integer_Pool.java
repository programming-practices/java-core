package others;

public class Integer_Pool {
    public static void main(String[] args) {

//======================================================================================================================

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);         // false
        System.out.println(a.equals(b));    // true

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2 == b2);       // true
        System.out.println(a2.equals(b2));  // true

//======================================================================================================================

        Byte by = 127;
        Short sh = 127;

//        128
//        System.out.println(a == b);
//        a++;
//        System.out.println(a == b);
//        System.out.println(b);


    }
}
