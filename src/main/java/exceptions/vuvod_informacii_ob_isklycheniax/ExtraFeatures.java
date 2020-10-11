package exceptions.vuvod_informacii_ob_isklycheniax;

class MyException2 extends Exception {
    private int x;

    public MyException2() {
    }

    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from q()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from threeTuple()");
        throw new MyException2("Originated in threeTuple()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from fourTuple()");
        throw new MyException2("Originated in fourTuple()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}
