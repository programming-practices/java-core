package Examples.String_API;

public class ExampleCharacterGetDirectionality {

    public static void main(String[] args) {

        // create 2 character primitives ch1, ch2
        char ch1, ch2;

        // assign values to ch1, ch2
        ch1 = 'M';
        ch2 = '\u06ff';

        // create 2 byte primitives b1, b2
        byte b1, b2;

        // assign directionality of ch1, ch2 to b1, b2
        b1 = Character.getDirectionality(ch1);
        b2 = Character.getDirectionality(ch2);

        /**
         *  byte value 0 represents DIRECTIONALITY_LEFT_TO_RIGHT
         *  byte value 2 represents DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
         */

        System.out.println((int) ch1);
        System.out.println((int) ch2);
        String str1 = "Directionality of " + ch1 + " is " + b1;
        String str2 = "Directionality of " + ch2 + " is " + b2;

        // print b1, b2 values
        System.out.println(str1);
        System.out.println(str2);
    }
}
