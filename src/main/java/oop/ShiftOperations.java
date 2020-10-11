package oop;

public class ShiftOperations {
    public static void main(String[] args) {
        System.out.println("int");
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));


        System.out.println("long");
        long l = -1;
        System.out.println(Long.toBinaryString(l));
        l >>>= 10;
        System.out.println(Long.toBinaryString(l));


        System.out.println("short");
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));


        System.out.println("char");
        char ch = '1';
        System.out.println(Integer.toBinaryString(ch));
        ch >>>= 10;
        System.out.println(Integer.toBinaryString(ch));


        System.out.println("byte");
        byte b = -1;
        System.out.println(Integer.toBinaryString(b));
//        protectedVariable >>>= 10;
        System.out.println(Integer.toBinaryString(b >>> 10));
    }
}
