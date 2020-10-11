package dataType;

import static java.lang.System.out;

/**
 * Link sources of information:
 * 1. https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html
 * 2. https://www.w3schools.com/java/java_data_types.asp
 * 3. https://www.youtube.com/watch?v=inBUNUOrFVI&list=PLoij6udfBncilPJMzXtsOyUutDDULrtEm    Golovach
 */
public class PrimitiveDataType {
    public static void main(String[] args) {
//======================================================================================================================
//==================================================== byte ============================================================
//======================================================================================================================

        // The byte data type can store whole numbers from -128 to 127. This can be used instead of int or other
        // integer types to save memory when you are certain that the value will be within -128 and 127:
        byte myByte = 100;
//        System.out.println(myByte);

        // not allowed to divide by zero
//        System.out.println(myByte / 0);

//======================================================================================================================
//==================================================== short ===========================================================
//======================================================================================================================

        // The short data type can store whole numbers from -32768 to 32767:
        short myShort = 5000;
//        System.out.println(myShort);

        // not allowed to divide by zero
//        System.out.println(myShort / 0);

//======================================================================================================================
//==================================================== int =============================================================
//======================================================================================================================

        // The int data type can store whole numbers from -2147483648 to 2147483647. In general, and in our tutorial,
        // the int data type is the preferred data type when we create variables with a numeric value.
        int myInt = 100000;
//        System.out.println(myInt);

        // not allowed to divide by zero
//        System.out.println(myInt / 0);

        // Test int
//        System.out.println(10 * 4D);     // Output: type double 40.0

//        System.out.println(10 * 4F);     // Output: type double or float ??? 40.0 (most likely it will be type double)
        float v = 10 * 4F;
        double v1 = 10 * 4F;

//        System.out.println(10 / 12L);
        long l = 10 / 12L;

        // Test comparison
//        System.out.println(10 == 10L);        // true
//        System.out.println(10 == 10.0F);      // true
//        System.out.println(10 == 10.0D);      // true


//======================================================================================================================
//==================================================== long ============================================================
//======================================================================================================================

        // The long data type can store whole numbers from -9223372036854775808 to 9223372036854775808. This is used
        // when int is not large enough to store the value. Note that you should end the value with an "L" or "l":
        long myLong = 15000000000L;
        // It is better not to use the letter 'l' in lower case, because it looks like the number one.
        long myLong_1 = 15000000000l;
//        System.out.println(myLong);
//        System.out.println(myLong_1);

        // not allowed to divide by zero
//        System.out.println(1L / 0);     // ArithmeticException: / by zero
//        System.out.println(-1L / 0);     // ArithmeticException: / by zero

        // Test long

//======================================================================================================================
//==================================================== float ===========================================================
//======================================================================================================================

        // The float data type can store fractional numbers from 3.4e−038 to 3.4e+038. Note that you should end
        // the value with an "methodoImprimir" or "F":
        float myFloat = 5.75f;
        float myFloat_1 = 5.75F;
//        System.out.println(myFloat);
//        System.out.println(myFloat_1);

        // allowed to divide by zero
//        System.out.println(1.0F / 0);     //  Infinity
//        System.out.println(0.0F / 0);     //  NaN
//        System.out.println(-1.0F / 0);    // -Infinity

//======================================================================================================================
//==================================================== double ==========================================================
//======================================================================================================================

        // The double data type can store fractional numbers from 1.7e−308 to 1.7e+038. Note that you should
        // end the value with a "d" or "D":
        double myDouble = 19.99d;
        double myDouble_1 = 19.99D;
        //constant 19.99 is of type double,
        double myDouble_2 = 19.99;
//        System.out.println(myDouble);
//        System.out.println(myDouble_1);
//        System.out.println(myDouble_2);

        // allowed to divide by zero
//        System.out.println(1.0D / 0);     //  Infinity
//        System.out.println(0.0D / 0);     //  NaN
//        System.out.println(-1.0D / 0);    // -Infinity

        // Test NaN
        String str = "NaN";
        double d = Double.valueOf(str);
//        System.out.println(d);          // NaN
//        System.out.println(d > 2D);     // false
//        System.out.println(d < 2D);     // false
//        System.out.println(d == 2D);    // false

        // Test Infinity
        String str2 = "Infinity";
        double d2 = Double.valueOf(str2);
//        System.out.println(d2);          // Infinity
//        System.out.println(d2 > 2D);     // true
//        System.out.println(d2 < 2D);     // false
//        System.out.println(d2 == 2D);    // false

        // Test -Infinity
        String str3 = "-Infinity";
        double d3 = Double.valueOf(str3);
//        System.out.println(d3);          // -Infinity
//        System.out.println(d3 > 2D);     //  false
//        System.out.println(d3 < 2D);     //  true
//        System.out.println(d3 == 2D);    //  false


//======================================================================================================================
//============================================= Scientific Numbers =====================================================
//======================================================================================================================

        //A floating point number can also be a scientific number with an "e" to indicate the power of 10
        float f1 = 35e3f;
        double d1 = 12E4d;
//        System.out.println(f1);
//        System.out.println(d1);

//======================================================================================================================
//=================================================== boolean ==========================================================
//======================================================================================================================

        // A boolean data type is declared with the boolean keyword and can only take the values true or false:
        boolean isJavaFun = true;
        boolean isFishTasty = false;
//        System.out.println(isJavaFun);     // Outputs true
//        System.out.println(isFishTasty);   // Outputs false

//======================================================================================================================
//==================================================== char ============================================================
//======================================================================================================================

        // The char data type is used to store a single character. A char value must be surrounded by
        // single quotes, like 'A' or 'c':
        char myChar = 'B';
//        System.out.println(myChar);

        // not allowed to divide by zero
//        System.out.println(myShort / 0);

        // test multiplication char
        char c1 = 'f';
        char c2 = 'a';
//        System.out.println(c1 + c2);                    // Output: 199
//        System.out.println((char)c1 + c2);              // Output: 199
//        System.out.println((char)(c1 + c2));            // Output: Ç
//        System.out.println(((char)c1) + ((char)c2));    // Output: 199

//======================================================================================================================
//=============================================== Others examples ======================================================
//======================================================================================================================

        // Which of the following lines will compile without errors and warnings?
//        float fArgInt = 1.3;      // constant 1.3 is of type double, you need to use 1.3f
        int i = 10;                 // Ok
//        char c = "a";             // character constants are written in single quotes: 'a'
//        byte b = 255;             // value range for byte: from -128 to 127
//        boolean b = null;         // null is valid only for reference types.

        char char_q = 'q';
        char char_f = 'f';
        byte byte_10 = 10;
        byte byte_100 = 100;
        byte byte_result = (byte) (byte_10 * byte_100);
//        System.out.println(byte_result);

        int aa2 = char_q & char_f;
        char a = (char) (char_q & char_f);
//        System.out.println(a + " " + aa2);

        int bb = char_q;
        int ff = char_q << 2;
        char ffchar = (char) (char_q << 2);
        int vv = char_q >> 2;
//        System.out.println(bb);
//        System.out.println(ff);
//        System.out.println(ffchar);
//        System.out.println(vv);

        char_q += char_f;
//        System.out.println(char_f);

//======================================================================================================================
//============================================= transfer by value ======================================================
//======================================================================================================================

        int valueX = 0;
        int valueY
                = valueX;
        valueX = 1;
//        out.println("valueX = " + valueX);
//        out.println("valueY = " + valueY);

        int value = 0;
        out.println(value);
        value = method_1(value);
        out.println(value);

        int valueQ = 0;
        out.println(valueQ);
        method_2(valueQ);
        out.println(valueQ);


//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

    }

    public static int method_1(int value) {
        return value + 1;
    }

    public static void method_2(int value) {
        value = value + 1;
    }
}


/*

There are eight primitive data types in Java:
Data Type       Size       Default Value         Description
  byte	       8 bit	         0          Stores whole numbers from -128 to 127 inclusive
  short	       16 bit	         0          Stores whole numbers from -32768 to 32767 inclusive
  int	       32 bit	         0          Stores whole numbers from -2147483648 to 2147483647 inclusive
  long	       64 bit	         0          Stores whole numbers from -9223372036854775808 to 9223372036854775807, inclusive
  float	       32 bit	        0.0f        Stores fractional numbers from 3.4e−038 to 3.4e+038. Sufficient for storing 6 to 7 decimal digits
  double       64 bit	        0.0         Stores fractional numbers from 1.7e−308 to 1.7e+038. Sufficient for storing 15 decimal digits
  char	       16 bit	       \u0000       For char, from '\u0000' to '\uffff' inclusive, that is, from 0 to 65535
  boolean    not specified     false        Stores true or false values


Primitive number types are divided into two groups:
    * Integer types stores whole numbers, positive or negative (such as 123 or -456), without decimals. Valid types
      are byte, short, int and long. Which type you should use, depends on the numeric value.
    * Floating point types represents numbers with a fractional part, containing one or more decimals.
      There are two types: float and double.

Use float or double?
      The precision of a floating point value indicates how many digits the value can have after the decimal point. The
      precision of float is only six or seven decimal digits, while double variables have a precision of about 15 digits.
      Therefore it is safer to use double for most calculations.

A floating point number can also be a scientific number with an "e" to indicate the power of 10.

Decimal numbers ALLOWED to divide by zero.
But "byte, short, char, int, long" NOT ALLOWED to divide by zero

If an arithmetic operation is made on variables of two different types, the result will be of a greater type.
For example "type int" divide to "type long" result will be a "type long".

The decimal values have three specific values: Infinity, -Infinity, NaN

*/