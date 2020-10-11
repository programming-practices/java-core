package exceptions;

public class ExampleExceptionLostMessage {
    public static void main(String[] args) {
//--------------------------------------lovywka-poterianoe-isklychenie-------------------------------------------------
        try {
            ExampleExceptionLostMessage lm = new ExampleExceptionLostMessage();
            try {
                lm.f();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    lm.dispose();

                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    try {
                        lm.method3();
                    } catch (Exception3 e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//---------------------------------------------------------------------------------------------------------------------
    }

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void method3() throws Exception3 {
        throw new Exception3();
    }
}

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class Exception3 extends Exception {
    public String toString() {
        return "A exception3";
    }
}

