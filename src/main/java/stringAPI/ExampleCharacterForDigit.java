package stringAPI;

public class ExampleCharacterForDigit {

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------------------------------

        // create 2 character primitives ch1, ch2
        char ch1, ch2;

        // create 2 int primitives i1, i2 and assign values
        int i1 = 3;
        int i2 = 14;

        // assign char representation of i1, i2 to ch1, ch2 using radix
        ch1 = Character.forDigit(i1, 10);
        ch2 = Character.forDigit(i2, 16);

        String str1 = "Char representation of " + i1 + " in radix 10 is " + ch1;
        String str2 = "Char representation of " + i2 + " in radix 16 is " + ch2;

        // print ch1, ch2 values
//        System.out.println( str1 );
//        System.out.println( str2 );

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // Let's see the simple code to convert long to int in java.
        int a = 65;
        char c = (char) a;
        System.out.println(a);

        System.out.println(c);

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // But if you store 1, it will store ASCII character of given number which is start of heading which is not
        // printable. So it will not print anything on the console
        int a1 = 1;
        char c1 = (char) a1;
        System.out.println(c1);
        System.out.println("value in int: " + (int) c1);

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // If you add '0' with int variable, it will return actual value in the char variable. The ASCII
        // value of '0' is 48. So, if you add 1 with 48, it becomes 49 which is equal to 1. The ASCII character of 49 is 1.
        int a2 = 1;
        // tyt vidbyvaetsa ne concatenacia a dodavannia
        char c2 = (char) (a2 + '0');
        System.out.println(c2);
        System.out.println("value in int: " + (int) c2);

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // If you store integer value in a single quote, it will store actual character in char variable.
        int a3 = '1';
        char c3 = (char) a3;
        System.out.println(c3);
        System.out.println(a3);

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // To get the actual value, you can also use Character.forDigit() method.
        int REDIX4 = 10;//redix 10 is for decimal number, for hexa use redix 16
        int a4 = 1;
        char c4 = Character.forDigit(a4, REDIX4);
        System.out.println(c4);

//-----------------------------------------------------------------------------------------------------------------------------------------------

        // To get the hexa value, use redix 16 in Character.forDigit() method
        int REDIX5 = 16;//redix 16 is for Hexadecimal value
        int a5 = 10;
        char c5 = Character.forDigit(a5, REDIX5);
        System.out.println(c5);

//-----------------------------------------------------------------------------------------------------------------------------------------------
    }
}
