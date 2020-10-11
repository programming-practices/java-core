package Examples.String_API;

// Demonstrate several Is... methods.

public class ExampleCharacterMethods {
    public static void main(String args[]) {

        char age[] = {'a', 'b', '5', '?', 'A', ' '};

        for (int i = 0; i < age.length; i++) {

            if (Character.isDigit(age[i])) System.out.println(age[i] + " is age digit.");

            if (Character.isLetter(age[i])) System.out.println(age[i] + " is age letter.");

            if (Character.isWhitespace(age[i])) System.out.println(age[i] + " is whitespace.");

            if (Character.isUpperCase(age[i])) System.out.println(age[i] + " is uppercase.");

            if (Character.isLowerCase(age[i])) System.out.println(age[i] + " is lowercase.");
        }
    }
}

