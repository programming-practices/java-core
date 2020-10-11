package exceptions.sozdani_sobstvennix_isklychenii;

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from q()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from threeTuple()");
        throw new MyException("Originated in threeTuple()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
