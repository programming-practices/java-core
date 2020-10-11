package exceptions.Others;

public class NewException {
    public static void methodException1() {
        NullPointerException e = new NullPointerException("Verxnii yroven");
        e.initCause(new ArithmeticException("Prichina"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            methodException1();
        } catch (NullPointerException e) {
            System.out.println("Perexvachenoe isklychenie: " + e);
            System.out.println("Pervo prichina: " + e.getCause());
        }
    }
}
