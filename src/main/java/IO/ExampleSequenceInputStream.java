package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class ExampleSequenceInputStream {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate sequenced input.
        // This program uses the traditional approach to closing age file.
        int c;
        Vector<String> files = new Vector<String>();

        files.addElement("src/main/resources/IO/SequenceInputStream/file1.txt");
        files.addElement("src/main/resources/IO/SequenceInputStream/file2.txt");
        files.addElement("src/main/resources/IO/SequenceInputStream/file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);

        try {
            while ((c = input.read()) != -1)
                System.out.print((char) c);
        } catch (NullPointerException e) {
            System.out.println("Error Opening File.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Error Closing SequenceInputStream");
            }
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e) {
            return null;
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс Sequenc e i np u t S t ream позволяет соединить вместе несколько потоков
ввода типа I nput S t re am.
В процессе своей работы этот к.ласе делает запросы на чтение из первого по­
тока ввода типа I npu t S t re am до его исчерпания, а затем переходит к другому по­
току ввода. Если же указано перечисление типа Enumerat i on потоков, этот класс
обращается ко всем потокам ввода типа I nput S t re am по очереди до исчерпания
самого последнего из них. По достижении конца каждого файла связанный с ни м
поток ввода закрывается. Закрытие потока ввода, созданного средствами класса
Sequence l npu t S t ream, приводит к закрытию всех остальных открытых потоков.
----------------------------------------------------------------------------------------------------------------------
Обратите внимание на то, что если файл нельзя открыть, то в метод nex t E l e ­
ment ( ) возвращает пустое значение nu l l . Это приводит к генерированию исклю­
чения типа Nu l l Po interExcep t ion, перехватываемого в методе ma in ( ) .
----------------------------------------------------------------------------------------------------------------------
*/