package IO;

import java.io.FileWriter;
import java.io.IOException;

public class ExampleFileWriter {
    public static void main(String[] args) {
//-------------------------------------------------------------------------------------------------------------------
//        // Demonstrate FileWriter.
//        // This program uses try-with-resources. It requires JDK 7 or later.
//        String source = "Now is the time for all good men\n"
//                + " to come to the aid of their country\n"
//                + " and pay their due taxes.";
//        char buffer[] = new char[source.length()];
//        source.getChars(0, source.length(), buffer, 0);
//
//        try(FileWriter f0 = new FileWriter("src/main/resources/IO/FileWriter/file1.txt");
//            FileWriter f1 = new FileWriter("src/main/resources/IO/FileWriter/file2.txt");
//            FileWriter f2 = new FileWriter("src/main/resources/IO/FileWriter/file3.txt")){
//            // write to first file
//            for (int i=0; i < buffer.length; i += 2) {
//                f0.write(buffer[i]);
//            }
//
//            // write to second file
//            f1.write(buffer);
//
//            // write to third file
//            f2.write(buffer,buffer.length-buffer.length/4,buffer.length/4);
//
//        } catch(IOException e) {
//            System.out.println("An I/O Error Occured");
//        }
//-------------------------------------------------------------------------------------------------------------------
        String value1 = "123";
        String value2 = "456";
        String value3 = "789";
        try (FileWriter fileWriter1 = new FileWriter("src/main/resources/IO/FileWriter/file1.txt");
             FileWriter fileWriter2 = new FileWriter("src/main/resources/IO/FileWriter/file1.txt");
             FileWriter fileWriter3 = new FileWriter("src/main/resources/IO/FileWriter/file1.txt", true)) {

            char[] buffer1 = value1.toCharArray();
            fileWriter1.write(buffer1);
            fileWriter1.close(); // yakwo tyta nezrobutu closed() to fail bude zablokovanui cum writerom

//            char[] buffer2 = value2.toCharArray();
//            fileWriter2.write(buffer2);  //OSTOROZNO!!!!!! zdes perepisuvaetsa informacia v fail
//            fileWriter2.close();  // yakwo tyta nezrobutu closed() to fail bude zablokovanui cum writerom

            char[] buffer3 = value3.toCharArray();
            fileWriter3.write(buffer3);    //OBRATI VNIMANIE!!!!!! a zdes dobavliaetsa informacia v fail
            fileWriter3.close();  // yakwo tyta nezrobutu closed() to fail bude zablokovanui cum writerom

        } catch (IOException e) {
            e.getStackTrace();
        }
//-------------------------------------------------------------------------------------------------------------------
    }
}

/*
---------------------------------------------------------------------------------------------------------------------
Если esli prusozdanii obiekta v konstruktori ykazat логическое значение t r u e , то выводимые данные при­
соединяются в конце файла.
Создание объекта типа Fi leWr i t e r не зависит от того, существует ли файл.
Когда создается объект типа Fi l eWr i t e r , то попутно создается и файл , прежде
чем открыть его для вывода. Если же предпринимается попытка открыть ф айла,
доступный только для чтения, то генерируется исключение типа IOExcep t i on.

---------------------------------------------------------------------------------------------------------------------
*/