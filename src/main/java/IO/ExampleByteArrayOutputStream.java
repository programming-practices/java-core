package IO;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleByteArrayOutputStream {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate ByteArrayOutputStream.
        // This program uses try-with-resources. It requires JDK 7 or later.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String s = "This should end up in the array";
        byte buf[] = s.getBytes();

        try {
            byteArrayOutputStream.write(buf);
        } catch (IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as age string");
        System.out.println(byteArrayOutputStream.toString());
        System.out.println("Into array");
        byte b[] = byteArrayOutputStream.toByteArray();
        for (int i = 0; i < b.length; i++) System.out.print((char) b[i]);

        System.out.println("\nTo an OutputStream()");

        // Use try-with-resources to manage the file stream.
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/IO/byteArrayOutputStream.txt")) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }

        System.out.println("Doing age reset");
        byteArrayOutputStream.reset();

        for (int i = 0; i < 3; i++) byteArrayOutputStream.write('X');

        System.out.println(byteArrayOutputStream.toString());
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс B yteArrayOutput S t r e am реали3ует поток вывода, исполЬ3ующий масив байтов в качестве адресата.
----------------------------------------------------------------------------------------------------------------------
ВyteArrayOutputStream ( )
ВyteArrayOutputStreaa ( int kolicheatvo baitov)

В первой форме конструктора со3дается буфер ра3мером 32 байта, а в о вто­
рой форме - буфер, ра3мер которого составляет 33.Данное количе ств о_ ба йтов.
Этот буфер хранится в 3ащищенном поле buf класса ByteArrayOutputStream.
Ра3мер буфера увеличивается автоматически по мере необходимости. Количество
байтов, содержащихся в буфере, хранится в 3ащищенном поле count класса
ByteAr rayOutpu t S t r e am.
Метод сlоsе ( ) не оказывает никакого влияния на класс ByteArrayOutputStream.
Поэтому вы3ывать его для объекта класса ByteArrayOutputStream не нужно, хотя
это и не считается ошибкой.
----------------------------------------------------------------------------------------------------------------------
*/