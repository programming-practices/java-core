package IO;

import java.io.*;
import java.util.Scanner;

public class ExampleScanner {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/IO/tempScanner.txt";

        Thread thread = new Thread(() -> {
            try (Scanner scanner = new Scanner(new FileReader(filePath))) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.next());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.write("str1");
            writer.write("\n");
            writer.write("str2");
        }

        thread.start();
    }
}

/*
 * -----------------------------------------------------------------------------
 * ------------------------------------------ Scanner(Inputstream in)
 * Конструирует объект типа Scanner на основе заданного потока ввода. • String
 * nextLineO Читает очередную строку. • String next() Читает очередное вводимое
 * слово, отделяемое пробелами. • int nextlnt() • double nextDoubleO Читает
 * очередную последовательность символов, представляющую целое число или число с
 * пла­ вающей точкой, выполняя соответствующее преобразование. • boolean
 * hasNextO Проверяет, присутствует ли еще одно слово в потоке ввода. • boolean
 * hasNextlntO • boolean hasNextDoubleO Проверяют, присутствует ли в потоке
 * ввода последовательность символов, представляющая целое число или число с
 * плавающей точкой.
 * -----------------------------------------------------------------------------
 * ------------------------------------------
 */