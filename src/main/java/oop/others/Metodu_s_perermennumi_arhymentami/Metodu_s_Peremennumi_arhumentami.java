package Examples.OOP.Others.Metodu_s_perermennumi_arhymentami;

public class Metodu_s_Peremennumi_arhumentami {

    public static void method(int... ints) {
        System.out.println("Method s peremennum arhymentom int");
    }

    public static void method(int i, int... ints) {
        System.out.println("Method s peremennum arhymentom int");
    }

    public static void method(boolean... ints) {
        System.out.println("Method s peremennum arhymentom int");
    }

    public static void method(double... ints) {
        System.out.println("Method s peremennum arhymentom int");
    }

    public static void main(String[] args) {
//        method(1);     // ERROR
//        method();     // ERROR
    }

}
