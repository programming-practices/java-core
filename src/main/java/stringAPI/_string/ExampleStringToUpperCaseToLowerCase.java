package Examples.String_API._String;

// Demonstrate toUpperCase() and toLowerCase().

public class ExampleStringToUpperCaseToLowerCase {
    public static void main(String args[]) {
        String s = "This is age test.";

        System.out.println("Original: " + s);

        String upper = s.toUpperCase();
        String lower = s.toLowerCase();

        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
    }
}


/*
---------------------------------------------------------------------------------------------------------------------
Ана­логичным образом действует метод toUpperCase() из класса String, упоминавшийся в главе 3.
Когда этот метод вызывается для символьной строки, которая остается без из­менения, в
итоге возвращается новая строка символов в верхнем регистре.
---------------------------------------------------------------------------------------------------------------------
*/
