package operators;

/**
 * Sources:
 * 1. https://www.tutorialspoint.com/Java-Bitwise-Operators
 */
public class BitwiseOperators {
    public static void main(String[] args) {
        byte a = (byte) 00111100;
        byte b = (byte) 00001101;
        System.out.println((byte) (a & b));
        System.out.println(a | b);
        System.out.println(a ^ b);
//        System.out.println(a  b);

    }
}


/*

Java defines several bitwise operators, which can be applied to the integer types, long, int, short, char, and byte.

Bitwise operator works on bits and performs the bit-by-bit operation. Assume if a = 60 and b = 13; now in binary format
they will be as follows:

a = 0011 1100
b = 0000 1101
-----------------
a&b = 0000 1100
a|b = 0011 1101
a^b = 0011 0001
~a = 1100 0011

The following table lists the bitwise operators −
Assume integer variable A holds 60 and variable B holds 13 then −

*/