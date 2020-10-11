package IO;

import java.io.CharArrayReader;
import java.io.IOException;

public class ExampleCharArrayReader {
    public static void main(String[] args) {
//-------------------------------------------------------------------------------------------------------------------
        // Demonstrate CharArrayReader.
        // This program uses try-with-resources. It requires JDK 7 or later.
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        int length = tmp.length();
        char charsTmp[] = new char[length];

        tmp.getChars(0, length, charsTmp, 0);
        int i;

        try (CharArrayReader charArrayReader1 = new CharArrayReader(charsTmp)) {
            System.out.println("input1 is:");
            while ((i = charArrayReader1.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        try (CharArrayReader charArrayReader2 = new CharArrayReader(charsTmp, 0, 5)) {
            System.out.println("\ninput2 is:");
            while ((i = charArrayReader2.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//-------------------------------------------------------------------------------------------------------------------
    }
}

/*
---------------------------------------------------------------------------------------------------------------------
Класс Cha rAr rayReader реализует поток вывода, использующий массив в ка­
честве источника данных.
---------------------------------------------------------------------------------------------------------------------
*/