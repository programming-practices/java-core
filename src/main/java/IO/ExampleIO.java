package IO;

import java.io.*;
import java.util.zip.ZipInputStream;

public class ExampleIO {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/IO/temp.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        int readValue = 0;
        while ((readValue = bufferedReader.read()) != -1) {
            System.out.println((char) readValue);
        }
        char[] chars = new char[50];
        while (bufferedReader.read(chars) != -1) {
            for (int i = 0; i < chars.length; i++) {
                if (Character.isAlphabetic(chars[i]) || Character.isWhitespace(chars[i])) {
                    System.out.println(chars[i]);
                }

            }
            // System.out.println(chars);
        }
        while (bufferedReader.read() != -1) {
            System.out.println(bufferedReader.readLine());
        }
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath));) {
            writer2.write("str1");
            writer2.newLine();
            writer2.write("str2");
        }
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        int i = 0;
        while ((i = inputStream.read()) != -1) {
            System.out.println(i);
        }
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.read(bytes) != -1) {
            for (int q = 0; q < bytes.length; q++) {
                System.out.println(bytes[q]);
            }
        }
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytes2 = new byte[]{49, 10, 50};
            outputStream.write(bytes2);
        }
        ZipInputStream zipInputStream = new ZipInputStream(new DataInputStream(
                new BufferedInputStream(new FileInputStream("src/main/resources/IO/example_ZipInputStream"))));

    }
}
