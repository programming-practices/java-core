package IO;

import java.io.FileInputStream;
import java.io.IOException;

public class ExampleFileInputStream {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate FileInputStream.
        // This program uses try-with-resources. It requires JDK 7 or later.
        int size;
        String fileName = "src/main/resources/IO/FileInputStreamDemo.txt";
        // Use try-with-resources to close the stream.
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            System.out.println("Total Available Bytes: " + (size = fileInputStream.available()));

            int n = size / 40;
            System.out.println("First " + n + " bytes of the file one read() at age time");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fileInputStream.read());
            }

            System.out.println("\nStill Available: " + fileInputStream.available());

            System.out.println("Reading the next " + n + " with one read(b[])");
            byte byteArray[] = new byte[n];
            if (fileInputStream.read(byteArray) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }

            System.out.println(new String(byteArray, 0, n));
            System.out.println("\nStill Available: " + (size = fileInputStream.available()));
            System.out.println("Skipping half of remaining bytes with skip()");
            fileInputStream.skip(size / 2);
            System.out.println("Still Available: " + fileInputStream.available());

            System.out.println("Reading " + n / 2 + " into the end of array");
            if (fileInputStream.read(byteArray, n / 2, n / 2) != n / 2) {
                System.err.println("couldn't read " + n / 2 + " bytes.");
            }

            System.out.println(new String(byteArray, 0, byteArray.length));
            System.out.println("\nStill Available: " + fileInputStream.available());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
В то же время методы mark() и reset() не переопределяются, и поэтому все попытки использовать метод reset() вместе с
объектом типа FileInputStream приводят к генерированию исключения типа IOException.
-----------------------------------------------------------------------------------------------------------------------
• FileInputStream (String name)
• FileInputStream (File file)
    Создают новый поток ввода из файла, путь к которому указывается в символьной строке паше или в объекте file. (Более подробно
    класс File описывается в конце этой главы.) Если указываемый путь не является абсолютным, он определяется относительно рабочего
    каталога, который был установлен при запуске виртуальной машины.


-----------------------------------------------------------------------------------------------------------------------
*/