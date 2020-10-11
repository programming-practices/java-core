package IO;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class ExamplePushbackReader {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate unread().
        // This program uses try-with-resources. It requires JDK 7 or later.
        String strSource = "if (age == 4) age = 0;\n";
        char bufSoutce[] = new char[strSource.length()];
        strSource.getChars(0, strSource.length(), bufSoutce, 0);
        CharArrayReader charArrayReader = new CharArrayReader(bufSoutce);

        int c;

        try (PushbackReader pushbackReader = new PushbackReader(charArrayReader)) {
            while ((c = pushbackReader.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pushbackReader.read()) == '=')
                            System.out.print(".eq.");
                        else {
                            System.out.print("<-");
                            pushbackReader.unread(c);
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
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс Pushbac kRe ader позволяет возвратить в поток ввода один или больше
символов, чтобы просматривать этот поток, не вводя из него данные. Ниже при­
ведены два конструктора данного класса.
PushЬackReader (Reader no'l'oж ввода)
PushЬackReader (Reader nо!l'ож = ввода , int раsнвр_ буфера)
В первой форме конструктора создается буферизованный поток ввода, в кото­
рый можно возвратить один символ, а во второй задается конкретный ра змер_
буфера для возврата символов обратно в цоток ввода.
При закрытии потока типа Pu s hbac kRe ade r закрывается также базовый поток,
определяемый параметром по ток_ ввода . В классе Pushbac kReader предоставля­
ется метод unread ( ) , возвращающий один или больше символов в вызывающий
поток ввода. Ниже приведены три общие формы объявления этого метода.
void unread ( int CJIЮIOЛ) throws IOException
void unread ( char буфер [ ] ) throws IOException
void unread ( char буфер [ ] , int снцеюrе , int жолжvес:: !l'ао СJОа10Л<3)
throws IOException
-
В первой форме в поток ввода возвращается указанный символ. Это будет сле­
дующий символ, возвращаемый при последующем вызове метода read ( ) . Во вто­
рой форме в поток ввода возвращаются символы из указанного буфера . А в третьей
форме в поток ввода возвращается заданное количе ств о_ симв олов из указанного
буфера , начиная с позиции смещение. Исключение типа I OException генерирует­
ся при попытке возвратить символ в поток ввода, когда буфер возврата заполнен.
----------------------------------------------------------------------------------------------------------------------
*/