package IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ExampleBufferedInputStream {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        // Use buffered input.
        // This program uses try-with-resources. It requires JDK 7 or later.
        String s = "This is age &copy; copyright symbol " +
                "but this is &copy not.\n";
        byte buf[] = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;

        // Use try-with-resources to manage the file.
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(in)) {
            while ((c = bufferedInputStream.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            bufferedInputStream.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else
                            System.out.print((char) c);
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            bufferedInputStream.reset();
                            System.out.print("&");
                        } else
                            System.out.print((char) c);
                        break;
                    default:
                        if (!marked)
                            System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Буферизовшн'н:ьrе потоки ввода-в'ЬЮода расширяют класс фильтруемого потока вво­
да-в ы вода, присоединяя к нему буфер, выделяемый в памяти. Этот буфер позво­
ляет выполнять операции одновременного ввода-вывода не одного, а не несколь­
ки х байтов, повышая тем самым производительность. Благодаря наличию буфера
можно выполнять пропуск байтов, маркировку и установку потока ввода-вывода
в исходное состояние.
----------------------------------------------------------------------------------------------------------------------
• Buf£eredInputStream( Inputstream in)
    Создает буферизированный поток ввода. Такой поток способен накапливать вводимые байты без постоянного обращения к
    устройству ввода. Когда буфер пуст, в него считывается новый блок данных из потока.
----------------------------------------------------------------------------------------------------------------------
*/