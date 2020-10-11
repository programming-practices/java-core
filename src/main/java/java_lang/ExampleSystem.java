package java_lang;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExampleSystem {
    public static void main(String[] args) throws FileNotFoundException {

//        System.setIn();

        System.setOut(new PrintStream(new FileOutputStream("src/main/resources/ExampleSystem.txt", true)));
        System.out.println("fdfdfsfas");
    }
}

