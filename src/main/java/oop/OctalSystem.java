package oop;

public class OctalSystem {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " = " + Integer.toOctalString(i));
        }
// ---------------------------------------------------------------------------------------------------------------------
        int v = 0123;
        int v2 = 034;
        int v3 = 010;
        System.out.println(v);
        System.out.println(v2);
        System.out.println(v3);
// ---------------------------------------------------------------------------------------------------------------------
    }
}
