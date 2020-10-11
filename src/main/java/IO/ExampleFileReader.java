package IO;

import java.io.FileReader;
import java.io.IOException;

public class ExampleFileReader {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate FileReader.
        // This program uses try-with-resources. It requires JDK 7 or later.
        try (FileReader fr = new FileReader("src/main/resources/IO/FileReaderDemo.txt")) {
            int c;

            // Read and display the file.
            while ((c = fr.read()) != -1) System.out.print((char) c);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------
*/