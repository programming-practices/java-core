package oop;


import static java.lang.System.out;

/**
 * Convert an integer into binary, hexadecimal, and octal.
 */
public class Integer_ToBinaryStirng_ToOctalString_ToHexString {
    public static void main(String args[]) {

        int num = 19648;

        out.println(num + " in binary: " + Integer.toBinaryString(num));

        out.println(10 + " in binary: " + Integer.toBinaryString(10));

        out.println(num + " in octal: " + Integer.toOctalString(num));

        out.println(num + " in hexadecimal: " + Integer.toHexString(num));

//======================================================================================================================

        out.println("300 in binary: " + (Integer.toBinaryString(300)));
        out.println("44  in binary: " + (Integer.toBinaryString(44)));

//======================================================================================================================
    }
}

