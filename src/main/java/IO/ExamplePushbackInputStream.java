package IO;

import java.io.*;

public class ExamplePushbackInputStream {
    public static void main(String[] args) throws IOException {
//---------------------------------------------------------------------------------------------------------------------
        /*Иногда возникает потребность отслеживать промежуточные потоки ввода-вывода, когда они соединяются в цепочку.
        Например, при чтении входных данных нередко требуется считывать следующий байт с упреждением, чтобы выяснить,
//        содержится ли в нем предполагаемое значение. Для этой цели в Java предоставляется класс PushbacklnputStream:*/
        PushbackInputStream pushbackInputStream1 = new PushbackInputStream(
                new BufferedInputStream(new FileInputStream("src/main/resources/IO/employee.dat")));
        /*Теперь можно прочитать сначала следующий байт с упреждением:*/
        int b = pushbackInputStream1.read();
        // а затем возвратить его обратно, если он не содержит именно то, что нужно:
        if (b != '<') pushbackInputStream1.unread(b);
        /*Но методы чтения read() и непрочтения unread() являются единственными методами, которые можно применять в потоке
        ввода типа PushbacklnputStream.*/
//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate unread().
        // This program uses try-with-resources. It requires JDK 7 or later.
        String stringSource = "if (age == 4) age = 0;\n";
        byte bufSource[] = stringSource.getBytes();
        ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(bufSource);
        int c;
        try (PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream1)) {
            while ((c = pushbackInputStream.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pushbackInputStream.read()) == '=')
                            System.out.print(".eq.");
                        else {
                            System.out.print("<-");
                            pushbackInputStream.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//---------------------------------------------------------------------------------------------------------------------
        // declare a buffer and initialize its size:
        byte[] byteBuffer = new byte[1024];
        // create an array for our message
        byte[] bytesSourcesFirst = new byte[]{'H', 'e', 'l', 'l', 'o'};
        // create object of PushbackInputStream class for specified stream
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytesSourcesFirst);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream, 10);
        try {
            // read from the buffer one character at a time
            for (int i = 0; i < bytesSourcesFirst.length; i++) {
                // read a char into our array
                byteBuffer[i] = (byte) pushbackInputStream.read();
                // display the read byte
                System.out.print((char) byteBuffer[i]);
            }
            // change line
            System.out.println();
            // create a new byte array to be unread
            byte[] bytesSourcesSecond = {'W', 'o', 'r', 'l', 'd'};
            // unread the byte array
            pushbackInputStream.unread(bytesSourcesSecond);
            // read again from the buffer one character at a time
            for (int i = 0; i < bytesSourcesFirst.length; i++) {
                // read a char into our array
                byteBuffer[i] = (byte) pushbackInputStream.read();
                // display the read byte
                System.out.print((char) byteBuffer[i]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Буферизовшн'н:ьrе потоки ввода-в'ЬЮода расширяют класс фильтруемого потока ввода-вывода, присоединяя к нему буфер, выделяемый
в памяти. Этот буфер позволяет выполнять операции одновременного ввода-вывода не одного, а не нескольки х байтов, повышая
тем самым производительность. Благодаря наличию буфера можно выполнять пропуск байтов, маркировку и установку потока
ввода-вывода в исходное состояние.
----------------------------------------------------------------------------------------------------------------------
• PushbacklnputStream (Inputs tream in)
• PushbackInputStream (Inputs tream in, int size)
    Создают поток ввода или вывода с однобайтовым буфером для чтения с упреждением или буфером указанного размера для
    возврата данных обратно в поток.

• void unread (int b)
    Возвращает байт обратно в поток, чтобы он мог быть извлечен снова при последующем вызове для чтения.
                Параметры: b   Повторно читаемый байт
----------------------------------------------------------------------------------------------------------------------
*/