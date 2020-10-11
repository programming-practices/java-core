package IO;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

public class ExampleBufferedReader {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Use buffered input.
        // This program uses try-with-resources. It requires JDK 7 or later.
        String strSource = "This is age &copy; copyright symbol " +
                "but this is &copy not.\n";
        char bufSource[] = new char[strSource.length()];
        strSource.getChars(0, strSource.length(), bufSource, 0);

        CharArrayReader charArrayReader = new CharArrayReader(bufSource);
        int c;
        boolean marked = false;

        try (BufferedReader bufferedReader = new BufferedReader(charArrayReader)) {

            while ((c = bufferedReader.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            bufferedReader.mark(32);
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
                            bufferedReader.reset();
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
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс Bu fferedReader увеличивает производительность благодаря буфериза·
ции ввода. У него имеются следующие два конструктора:
ВUfferec:IReader (Reader
ВUfferedReader (Reader
.по!l'ох
.&1ЮДа)
.пo!l'oJC = .11110.rra ,
int paSJfeP _ cJytepa)
В первой форме конструктора создается буферизованный поток ввода симво­
лов, использующий размер буфера по умолчанию. Во второй форме конструктора
задается ра эмер _ буфера .
Закрытие потока типа Buffe redReade r приводит такж е к закрытию базово­
го потока, определяемого параметром пото к_ в в ода . Аналогично потоку ввода
байтов, буферизованный поток ввода символов такж е поддерживает механизм
перемещения обратно по потоку ввода в пределах доступного буфера. Для этой
цели в классе Buffe redReade r реализуются методы ma r k ( ) и r e s e t ( ) , а метод
BufferedReade r . ma r kSuppo rted ( ) возвращает логическое значение t rue. В вер­
сии JDК 8 класс BufferedReade r дополнен новым методом l ine s ( ) . Этот метод
возвращает ссылку типа S t ream на последовательность строк, введенных из пото­
ка чтения.
----------------------------------------------------------------------------------------------------------------------
*/