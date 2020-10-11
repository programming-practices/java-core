package exceptions;

public class ExampleRuntimeException {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        method();
        System.out.println("Good Bye!!!");
    }


    public static void method() {
        throw new IllegalArgumentException("Parameter is incorrect.");
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
•RuntimeException (Throwable cause) 1.4
•RuntimeException (String message, Throwable cause) 1.4
        Создают объект типа RuntimeException по заданному объекту cause.
-----------------------------------------------------------------------------------------------------------------------
*/