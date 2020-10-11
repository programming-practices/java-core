package stringAPI._string.StringPool.TestPackage;

public class Other {

    static String hello = "Hello";
}

//In File tem.Test.java
class Test {
    public static void main(String[] args) {

        String hello = "Hello", lo = "lo";
        System.out.println((Other.hello == hello) + " ");
        System.out.println((Other.hello == hello) + " ");
        System.out.println((hello == ("Hel" + "lo")) + " ");
        System.out.println((hello == ("Hel" + lo)) + " ");
        System.out.println(hello == ("Hel" + lo).intern());
    }
}
