package IO;

import java.io.*;

public class ExamplePrintWriter {
    static final String path = "src/main/resources/IO/ExamplePrintWrite.txt";

    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
//        PrintWriter pw = new PrintWriter(System.out, true);
//        pw.println("This is age string");
//        int i = -7;
//        pw.println(i);
//        double d = 4.5e-7;
//        pw.println(d);
//--------------------------------------------------------------------------------------------------------------------
//        try {
//            PrintWriter printWriter = new PrintWriter(new File("slfd"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//--------------------------------------------------------------------------------------------------------------------
        PrintWriter printWriter = null;
        try {
            // esli vukorustovuvat etot sposob to bydet owibka
//            printWriter = new PrintWriter("src/main/resources/IO/ExamplePrintWrite.txt", StandardCharsets.UTF_8);
            printWriter = new PrintWriter(path, "UTF-8");
//            printWriter = new PrintWriter("src/main/resources/IO/ExamplePrintWrite1.txt", "UTF-8");
            String name = "Harry Hacker";
            double salary = 75000;
            printWriter.print(name);
            printWriter.print(' ');
            printWriter.println(salary);
            // ochen vazno zdelat flush() ili close(), esli ne zdelat flush() ili close() to v fail necheho ne zapiwetsa
//            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
//--------------------------------------------------------------------------------------------------------------------
        /*Если поток записи выводимых данных устанавливается в режим
        автоматической очистки, то при каждом вызове метода println () все символы, хранящиеся
        в буфере, отправляются по месту их назначения. (Потоки записи выводимых
        данных всегда снабжаются буфером.) По умолчанию режим автоматической
        очистки не включается. Его можно включать и выключать с помощью конструктора
        PrintWriter (Writer out, boolean autoFlush) //следующим образом:*/
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "UTF-8"), true); // автоматическая очистка
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
---------------------------------------------------------------------------------------------------------------------
Методы типа print не генерируют исключений. Чтобы проверить наличие ошибок в потоке вывода, следует вызывать метод checkError().
---------------------------------------------------------------------------------------------------------------------
Класс P r i n tWr i t e r , по существу, является символьной версией кл а сс а
P r in t S t ream. Он реализует интерфейсы AppendaЬ l e , C l o s eaЫe и Flu s haЫe.
У класса Р r in t Wr i t e r имеется несколько конструкторов. Рассмотрим сначала сле­
дующие формы конструкторов этого класса:
PrintWriter (OUtputstreaш ПO!lrOll: - .811ВОД'а)
PrintWriter (OUtputstreaa ПO!lrOZ -ода , Ьoolean aa!l.'OO'irЖC!l'Za)
PrintWriter (Vriter по!l'оа: .-а�ода)
Print1friter (Writer ПО!l'ОХ = .-UЮД'а , Ьoo lean a.!l'OOV•C!l'Za)
где параметр поток_ вывода обозначает открытый поток вывода типа Output
S t r e am, который будет принимать выводимые данные. Параметр а в тоочистка
определяет, будет ли буфер вывода автоматически очищаться всякий раз, к ог д а вы·
зывается мeтoд p r i n t l n ( ) , p r i n t fArgInt ( ) или forma t ( ) . Если параметр а в тоочистка
принимает логическое значение t rue , то происходит автоматическая очистка
буфера вывода. А если этот параметр принимает логическое значение fArgInt a l s e , то
очистка буфера вывода не производится автоматически. Конструкторы, не при·
нимающие параметр а втоочистка , не производят очистку буфера вывода автома·
тически.
Следующий ряд конструкторов предоставляет простую возможность создать
объект класса P r i n tWr i t e r для вывода данных в файл :
PrintWriter (File файл SllВOдa) throws FileNotFoundException
-
PrintWri ter (File фаiiл 818ода , String набор СJrНВОлоs)
n
throws FileNotFou dException , UnsupportedEncodingException
PrintWriter ( S tring •НR фаiiла - S11Вода) throws FileNotFoundException
PrintWri ter ( S tring .юl файла SAZ80дa , String набор СJrнаолоа)
throws FileNotFound:&:xcep tl on , UnsupportedEncoding:&:xception
Эти конструкторы позволяют создать объект класса P r intWr i t e r из объекта
типа File или по имени файла. Но в любом случае файл создается автоматиче­
с ки . Любой существующий файл с тем же именем уничтожается. Как только поток
вывода будет создан в виде объекта класса P r intWri t e r , он будет направлять все
выводимые данные в указанный файл. Конкретную кодировку символов можно за­
дать в качестве параметра на бор_ симв олов.
---------------------------------------------------------------------------------------------------------------------
На заметку! У программирующих на Java со стажем может возникнуть следующий вопрос:
что же случилось с классом PrintStream и стандартным потоком вывода System, out?
В версии Java 1.0 класс PrintStream просто усекал все символы Юникода до символов
в коде ASCII, отбрасывая старший байт (в то время в Юникоде еще применялась 16-раз-
рядная кодировка]. Очевидно, что такой подход не обеспечивал точность и переносимость
результатов, из-за чего он был усовершенствован внедрением в версии Java 1.1 потоков
чтения и записи данных. Для обеспечения совместимости с существующим кодом System,
in, System.out и System.err по-прежнему являются потоками ввода-вывода, но не
для чтения и записи данных.
Класс PrintStream теперь способен преобразовывать внутренним образом символы
Юникода в стандартную кодировку хоста точно так же, как и класс PrintWriter. Объекты типа
PrintStream действуют таким же образом, как и объекты типа PrintWriter, когда
вызываются методы print () и println (), но, в отличие от объектов типа PrintWriter, они
позволяют также выводить исходные байты с помощью методов write (int) и write (byte []).
---------------------------------------------------------------------------------------------------------------------
• PrintWriter(Writer out)
• PrintWriter(Writer out, boolean autoFlush)
    Создают новый экземпляр класса PrintWriter, выводящий данные в указанный поток записи.

• PrintWriter (OutputStream out)
• PrintWriter (OutputStream out, boolean autoflush)
    Создают новый экземпляр класса PrintWriter из существующего экземпляра класса OutputStream, получая необходимый
    промежуточный экземпляр класса Output-StreamWriter.PrintWriter (String filename, String encoding)

• PrintWriter (File file, String encoding)
    Создают новый экземпляр класса PrintWriter для записи данных в указанный файл, используя заданную кодировку.

• void print (Object obj)
    Выводит объект в виде символьной строки, получаемой из метода toStringO.

• void print (String s)
    Выводит символьную строку в виде кодовых единиц Юникода.

• void printin (String s)
    Выводит символьную строку вместе с символом окончания строки. Очищает поток вывода, если он действует в режиме автоматической очистки.

• void print (char [] з)
    Выводит все символы из указанного массива в виде кодовых единиц Юникода.

• void print (char с)
    Выводит символ в виде кодовой единицы Юникода.

• void print (int i)
• void print (long I)
• void print(float fArgInt)
• void print (double d)
• void print (boolean Jb)
    Выводят заданное значение в текстовом формате.

• void printf(String foxmat, Object... args)
    Выводит заданные значения так, как указано в форматирующей строке. О том, как задается форматирующая строка, см. в
    главе 3 первого тома настоящего издания.

• boolean checkError()
    Возвращает логическое значение true, если возникла ошибка при форматировании или выводе данных. При возникновении ошибки
    поток вывода считается испорченным, а в результате всех вызовов метода checkError() возвращается логическое значение true.
---------------------------------------------------------------------------------------------------------------------
*/