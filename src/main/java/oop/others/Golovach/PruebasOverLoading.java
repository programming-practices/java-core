package YouTube_Channels.Golovach_Courses.Java_Core_December_2013.Core_OOP_4_December_2013;

public class PruebasOverLoading {
    public static void main(String[] args) throws Exception {
        f(1);
        f("Hello");

    }

    public static void f(int e) {
        System.out.println("int = " + e);
    }

    public static int f(String s) throws Exception {
        System.out.println(s);
        return s.length();
    }

}
