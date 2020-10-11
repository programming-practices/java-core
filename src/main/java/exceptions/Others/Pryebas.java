package exceptions.Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pryebas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 5;
        int b = 0;

        try {
            int c = a / b;
            System.out.println("Rezyltat dilenia a/protectedVariable raven = " + c);
        } catch (ArithmeticException io) {
            System.out.println("Pri dilenii a/protectedVariable odno is chisel ravnol nyly");
            System.out.println(io.toString());
        }
    }
}
