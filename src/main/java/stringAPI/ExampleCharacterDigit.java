package stringAPI;

public class ExampleCharacterDigit {

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------

        // create 2 character primitives ch1, ch2
        char ch1, ch2;

        // assign values to ch1, ch2
        ch1 = '9';
        ch2 = '5';

        // create 2 int primitives i1, i2
        int valueInt_A, valueInt_B;

        // assign numeric value of ch1, ch2 to i1, i2 using radix
        valueInt_A = Character.digit(ch1, 2);
        valueInt_B = Character.digit(ch2, 10);

        String str1 = "Numeric value of " + ch1 + " in radix 2 is " + valueInt_A;
        String str2 = "Numeric value of " + ch2 + " in radix 10 is " + valueInt_B;

        // print i1, i2 values
        System.out.println(str1);
        System.out.println(str2);

//----------------------------------------------------------------------------------------------------------------------------------------------

        // create 2 int primitives cp11, cp22
        int cp11, cp22;

        // assign values to cp11, cp22
        cp11 = 0x0034;
        cp22 = 0x004a;

        // create 2 int primitives i11, i22
        int i11, i22;

        // assign numeric value of cp11, cp22 to i11, i22 using radix
        i11 = Character.digit(cp11, 8);
        i22 = Character.digit(cp22, 8);

        String str11 = "Numeric value of " + cp11 + " in radix 8 is " + i11;
        String str22 = "Numeric value of " + cp22 + " in radix 8 is " + i22;

        // print i11, i22 values
        System.out.println(str11);
        System.out.println(str22);

//----------------------------------------------------------------------------------------------------------------------------------------------

    }
}
