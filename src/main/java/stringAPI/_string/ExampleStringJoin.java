package stringAPI._string;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleStringJoin {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        String hello = "Hello";
        String habr = "habrahabr";
        String delimiter = ", ";

        System.out.println(String.join(delimiter, hello, habr));

        // или так
        System.out.println(String.join(delimiter, new ArrayList<CharSequence>(Arrays.asList(hello, habr))));
        // в обоих случаях "Hello, habrahabr"

//---------------------------------------------------------------------------------------------------------------------

        String result = String.join(" ", "Alpha", "Beta", "Gamma");
        System.out.println(result);

        result = String.join(", ", "John", "ID#: 569", "E-mail: John@HerbSchildt.com");
        System.out.println(result);

//--------------------------------------------------------------------------------------------------------------------
    }
}
