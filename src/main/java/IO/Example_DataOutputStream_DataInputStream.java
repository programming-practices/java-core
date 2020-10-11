package IO;

import java.io.*;

public class Example_DataOutputStream_DataInputStream {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate DataInputStream and DataOutputStream.
        // This program uses try-with-resources. It requires JDK 7 or later.
        // First, write the data.
        String path = "src/main/resources/IO/DataOutputStream_DataInputStream/tem.Test.txt";
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path))) {
            dataOutputStream.writeDouble(98.6);
            dataOutputStream.writeInt(1000);
            dataOutputStream.writeBoolean(true);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open Output File");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // Now, read the data back.
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path))) {

            double d = dataInputStream.readDouble();
            int i = dataInputStream.readInt();
            boolean b = dataInputStream.readBoolean();

            System.out.println("Here are the values: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open Input File");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
Эти классы позволяют выводить примитивные данные в поток или вводить их из потока. Они реализуют интерфейсы DataOutput
и DataInput соответственно.
----------------------------------------------------------------------------------------------------------------------
Когда поток вывода типа DataOutputStream закрывается в результате вызова метода close(), базовый поток, определяемый
параметром поток_ вывода, также закрывается автоматически.
----------------------------------------------------------------------------------------------------------------------
Например, метод writelnt () всегда записывает целочисленное значение
в виде 4-байтовой двоичной величины независимо от количества цифр, а метод
writeDouble () — числовое значение с плавающей точкой типа double в виде
8-байтовой двоичной величины. Выводимый в итоге результат неудобочитаем, но
в то же время объем требующегося пространства будет одинаковым для каждого
значения заданного типа, а обратное считывание таких значений будет
осуществляться намного быстрее, чем синтаксический анализ текста.
Метод writeUTF () записывает строковые данные, используя
модифицированную версию 8-разрядного формата преобразования Юникода. Вместо
стандартной кодировки UTF-8 символьные строки сначала представляются в кодировке
UTF-16, а полученный результат кодируется по правилам UTF-8. Для символов
с кодом больше OxFFFF модифицированная кодировка выглядит по-другому.
Она применяется для обеспечения обратной совместимости с виртуальными
машинами, которые были созданы в те времена, когда Юникод еще не мог
выходить за рамки 16 битов.
Но такой модифицированной версией UTF-8 уже никто не пользуется, и
поэтому для записи символьных строк, предназначенных для виртуальной
машины Java, например, при создании программы, генерирующей байт-коды,
следует использовать только метод writeUTF (), а для всех остальных целей — метод
writeChars ().
----------------------------------------------------------------------------------------------------------------------
На заметку! Для сохранения целочисленных значений и числовых значений с плавающей
точкой имеются два способа, зависящих от используемой платформы. Допустим, имеется
некоторое A-байтовое значение типа int, скажем, десятичное число 1234, или 4D2 в
шестнадцатеричном представлении (1234 = 4 х 256 + 13 х 16 + 2). С одной стороны, оно может быть
сохранено таким образом, чтобы четыре первых байта в памяти занимал его самый старший
байт: 00 00 04 D2. Такой способ называется сохранением в формате с обратным порядком
следования байтов от старшего к младшему. А с другой стороны, оно может быть сохранено
таким образом, чтобы первым следовал самый младший байт: D2 04 00 00. Такой
способ называется сохранением в формате с прямым порядком следования байтов от младшего
к старшему. На платформах SPARC, например, применяется формат с обратным порядком
следования байтов, а на платформах Pentium — формат с прямым порядком следования байтов.
Это может стать причиной серьезных осложнений. Например, данные сохраняются в
исходном файле программы на С или C++ именно так, как это делает процессор. Вследствие этого
перемещение даже простейших файлов данных с одной платформы на другую
превращается в совсем не простую задачу. А в Java все значения записываются в формате с обратным
порядком следования байтов от старшего к младшему независимо от типа процессора, что,
соответственно, делает файлы данных в Java независящими от используемой платформы.
----------------------------------------------------------------------------------------------------------------------
*/