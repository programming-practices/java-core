package oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class ExampleStaticImport {
    public static void main(String[] args) {

        int x = 3;
        int y = 9;

//        Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));     // a tak nemnozko xyze chitaimost
        double sqrt = sqrt(pow(x, 2) + pow(y, 2));// tak yrivok koda lydwe chitaetsa
        out.println(sqrt);
    }
}
