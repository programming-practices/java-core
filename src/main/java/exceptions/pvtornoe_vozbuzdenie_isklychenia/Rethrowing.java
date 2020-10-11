package exceptions.pvtornoe_vozbuzdenie_isklychenia;

public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in q()");
        throw new Exception("thrown from q()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside threeTuple(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside fourTuple(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
