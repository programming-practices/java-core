package exceptions.osobie_sluchai_runtime_exceptions;

public class NeverCaught {
    static void method_2() {
        throw new RuntimeException("From fArgInt()");
    }

    static void method_1() {
        method_2();
    }

    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
//        method_1();
//--------------------------------------------------------------------------------------------------------------------
        try {
            method_1();
        } catch (RuntimeException e) {
            System.out.println("Catch");
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}
