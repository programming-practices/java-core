package exceptions;

import java.io.IOException;

public class ExampleExceptionSilencer {
    public static void main(String[] args) {
        try {
//            throw new RuntimeException();
//            throw new Exception();
            throw new IOException();
        } finally {
            // Using 'return' inside the finally block
            // will silence any thrown exception.
            return;
        }
    }
}
