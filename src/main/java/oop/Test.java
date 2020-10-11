package oop;

import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
// --------------------------------------------------------------------------------------------------------------------
        int[] arrInt = new int[4];
        System.out.println(Arrays.toString(arrInt));

        boolean[] arrBoolean = new boolean[4];
        System.out.println(Arrays.toString(arrBoolean));

        // output to console [0.0, 0.0, 0.0, 0.0]
        double[] arrDouble = new double[4];
        // output to console [0.0, 0.0, 0.0, 0.0]
        // but not output to console [0.0f, 0.0f, 0.0f, 0.0f]
        float[] arrFloat = new float[4];
        float v = arrFloat[0];

        System.out.println(Arrays.toString(arrFloat));
        System.out.println(Arrays.toString(arrDouble));

        short[] arrShort = new short[4];
        System.out.println(Arrays.toString(arrShort));
// ---------------------------------------------------------------------------------------------------------------------


//        byte b0 = 20;
//        byte b1 = 5;
//        short s = 2;
//        int i = 6;
//        float fArgInt = 1.2f;
//        long l = 20;
//        double d = 2.1;
//        float f1 = .37f;    // 0.37
//        double d1 = .581;  // 0.581
//
//        System.out.println(d1);
//        System.out.println(f1);
//
//        int i0 = b0 + b1;
//        int i1 = b0 - b1;
//        int i2 = b0 * b1;
//        int i3 = b0 / b1;
//        int i4 = b0 + i;
//        float v = b0 - fArgInt;
//        float v1 = i - fArgInt;
//        double v2 = d - fArgInt;
//        double v3 = d - l;
//        double v4 = d - i;
//        int i5 = s - b0;
//        float v5 = i * fArgInt;
//        double v6 = d - i - l;
//        float v7 = i - fArgInt - l;
//        float v8 = i * fArgInt * l;


        //        int[][] arr0, arr1;
//        arr0 = new int[2][];
//        arr1 = new int[2][];
//        // Error compilation
//        // arr1 = new int[2];
//
//        int[]arr2[], arr3;
//        arr2 = new int[2][];
//        arr3 = new int[2];
//        // Error compilation
//        //arr3 = new int[2][];


//        double d = 128.8999999999999999999999999999999999999999999;
//        double d1 = 128.99999999999999;
//        double d2 = 128.9999999999999;
//        byte b1 = (byte) d;
//        byte b2 = (byte) d1;
//        byte b3 = (byte) d2;
//        System.out.println(b1);   //   -128
//        System.out.println(b2);   //   -127
//        System.out.println(b3);  //   -128

//        int i = 129;
//        byte b = (byte) i;
//        System.out.println(b);


//        int d = 3, e, r = 5;
//        System.out.println(d);
//        System.out.println(r);

        // Error of compilation, not initialised variable "e"
        // System.out.println(e);


//        String s0 = "\"Hola como estas\"";
//        String s1 = "tow\nlines";
//
//        System.out.println(s0);
//        System.out.println(s1);


//        char c0 = '\n';
//        char c1 = '\"';
//        char c2 = '\141';
////        char c3 = '141';     //   ERROR
//        char c4 = '\u0061';
//        char c5 = '\ua432';  // wesnadcaterichnoe predstavlenie
//        char c6 = '\277';    // vosmerichnoe predstavlenie
//        char c7 = '\'';
//        char c8 = '\\';
//
//        System.out.println(c0);
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c4);
//        System.out.println(c5);
//        System.out.println(c6);
//        System.out.println(c7);
//        System.out.println(c8);


//        double d0 = 6.022E23;   //   6.022 * 10 v 23 stepeni
//        double d1 = 314159E-05;  //  314159 * 10 v -5 stepeni
//        double d2 = 2e+100;      //  2 * 10 v 100 stepeni
//        double wecnadcetirichnoe11 = 0x12.2P2;
//        double num = 9_334_654.452_3;
//
//        System.out.println(d0);
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println(wecnadcetirichnoe11);
//        System.out.println(num);


//        int vosmerichnoe = 012;
//        int dvoichnoe = 0b1010;
//        int wesnadcaterichnoe = 0xa;
//        long wesnadcaterichnoe1 = 0x7fffffffffffffffL;
//        int x = 0b1101_0101_0001_1010 ;
//
//        System.out.println(vosmerichnoe);
//        System.out.println(dvoichnoe);
//        System.out.println(wesnadcaterichnoe);
//        System.out.println(wesnadcaterichnoe1);
//        System.out.println(x);


//        Integer i = 0x7fffffff;
//        int read = System.in..
//        System.out.println(Arrays.toString(args));
//        System.out.println();

//        for(int i = 0; i < 128; i++){
//            char c =(char) i;
//            System.out.print(i + " = (" + c + ")  ");
//        }


    }

}

