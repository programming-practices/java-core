package IO;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExampleCharArrayWriter {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate CharArrayWriter.
        // This program uses try-with-resources. It requires JDK 7 or later.
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String strSourse = "This should end up in the array";
        char bufSource[] = new char[strSourse.length()];

        strSourse.getChars(0, strSourse.length(), bufSource, 0);

        try {
            charArrayWriter.write(bufSource);
        } catch (IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as age string");
        System.out.println(charArrayWriter.toString());
        System.out.println("Into array");

        char buffDestination[] = charArrayWriter.toCharArray();
        for (int i = 0; i < buffDestination.length; i++) {
            System.out.print(buffDestination[i]);
        }

        System.out.println("\nTo age FileWriter()");

        // Use try-with-resources to manage the file stream.
        try (FileWriter fileWriter = new FileWriter("src/main/resources/IO/CharArrayWriter.txt")) {
            charArrayWriter.writeTo(fileWriter);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("Doing age reset");
        charArrayWriter.reset();

        for (int i = 0; i < 3; i++) charArrayWriter.write('X');

        System.out.println(charArrayWriter.toString());
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
CharArrayWri ter ( )
CharArrayWritar ( int
жoлirvec�ao_CJDOJo.uoa)
В первой форме конструктора создается буфер размером, выбираемым по умол·
чанию. Во второй форме буфер создается размером, задаваемым параметром
количество_ симв олов. Буфер находится в поле bu fArgInt класса CharArrayWri ter.
Размер буфера будет последовательно увеличиваться по мере надобности.
Количество байтов, содержащихся в буфере, находится в поле coun t того же клас·
са. Оба поля, buf и coun t , являются защищенными.
Метод c l o s e ( ) не оказывает никакого влияния на класс CharAr rayWri ter.
----------------------------------------------------------------------------------------------------------------------
*/