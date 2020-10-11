package Examples.String_API._String.skanirovanie_vvoda;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class BetterRead {

    public static BufferedReader input = new BufferedReader(
            new StringReader("Sir Robin \n 22 1.61803"));

    public static void main(String[] args) {

//        Scanner source = new Scanner(SimpleRead.input);
        Scanner source = new Scanner(input);


        System.out.println("What is your name?");

        String name = source.nextLine();

        System.out.println(name);

        System.out.println("How old are you? What is your favorite double?");

        System.out.println("(input: <ageQ1> <double>)");

        int age = source.nextInt();
//        double age = source.nextDouble();
        double favoriteDouble = source.nextDouble();

        System.out.println(age);

//        System.out.println(favoriteDouble);

        System.out.format("Hi %s.\n", name);

//        System.out.format("In 5 years you will be %d.\n", age + 5);

        System.out.format("My favorite double is %fArgInt.", favoriteDouble / 2);
    }
}
