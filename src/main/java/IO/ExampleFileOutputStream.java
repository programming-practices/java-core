package IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleFileOutputStream {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        // This program uses the traditional approach to closing age file.
//        // Demonstrate FileOutputStream.
//        String source = "Now is the time for all good men\n"
//                + " to come to the aid of their country\n"
//                + " and pay their due taxes.";
//        byte buf[] = source.getBytes();
//        FileOutputStream f0 = null;
//        FileOutputStream f1 = null;
//        FileOutputStream f2 = null;
//
//        try {
//            f0 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file1.txt");
//            f1 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file2.txt");
//            f2 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file3.txt");
//
//            // write to first file
//            for (int i=0; i < buf.length; i += 2) f0.write(buf[i]);
//
//            // write to second file
//            f1.write(buf);
//
//            // write to third file
//            f2.write(buf, buf.length-buf.length/4, buf.length/4);
//        } catch(IOException e) {
//            System.out.println("An I/O Error Occured");
//        } finally {
//            try {
//                if (f0 != null) f0.close();
//            } catch (IOException e) {
//                System.out.println("Error Closing file1.txt");
//            }
//            try {
//                if (f1 != null) f1.close();
//            } catch (IOException e) {
//                System.out.println("Error Closing file2.txt");
//            }
//            try {
//                if (f2 != null) f2.close();
//            } catch (IOException e) {
//                System.out.println("Error Closing file3.txt");
//            }
//        }

//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate FileOutputStream.
        // This version uses try-with-resources. It requires JDK 7 or later.
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte buf[] = source.getBytes();

        // Use try-with-resources to close the files.
        try (FileOutputStream f0 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file1.txt");
             FileOutputStream f1 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file2.txt");
             FileOutputStream f2 = new FileOutputStream("src/main/resources/IO/ExampleFileOutputStream/file3.txt")) {

            // write to first file
            for (int i = 0; i < buf.length; i += 2) f0.write(buf[i]);

            // write to second file
            f1.write(buf);

            // write to third file
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.out.println("An I/O Error Occured");
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
• FileOutputStream (String name)
• FileOutputStream(String name, boolean append)
• FileOutputStream(File file)
• FileOutputStream(File file, boolean append)
    Создают новый поток вывода в файл, который указывается в символьной строке name или в объекте file. (Более подробно
    класс File описывается в конце этой главы.) Если параметр append принимает логическое значение true, существующий файл
    с таким же именем не удаляется, а данные добавляются в конце файла. В противном случае удаляется любой уже
    существующий файл с таким же именем.
-----------------------------------------------------------------------------------------------------------------------
*/