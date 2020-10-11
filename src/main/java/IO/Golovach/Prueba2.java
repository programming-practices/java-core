package IO.Golovach;

public class Prueba2 {
    public static void main(String[] args) {

//        String str0 = "\u0FFF";
//        String str2 = "Adam\u0FFFNorvere";
//        String str1 = new String(new char[]{0x0FFF, 0x0FFF});
//        System.out.println(str0);
//        System.out.println(str1);

        printChar();
        printShort();
    }

    private static void printChar() {
        int c0 = 0xFFFF;
        char c1 = '\uFFFF';
        System.out.println((int) c0);
        System.out.println((int) c1);
    }

    private static void printShort() {
        short s = -32768; // Short.MIN_VALUE;
        System.out.println(Integer.toBinaryString(s));
    }
}
