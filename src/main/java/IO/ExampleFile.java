package IO;

import java.io.File;
import java.io.IOException;

public class ExampleFile {
    public static void main(String[] args) throws IOException {
//--------------------------------------------------------------------------------------------------------------------
        String separator = File.separator;
        System.out.println(separator);
//--------------------------------------------------------------------------------------------------------------------
//        // Demonstrate File.
//        File f1 = new File("src/main/resources/IO/COPYRIGHT.txt");
//
//        p("File Name: " + f1.getName());
//        p("Path: " + f1.getPath());
//        p("Abs Path: " + f1.getAbsolutePath());
//        p("Parent: " + f1.getParent());
//        p(f1.exists() ? "exists" : "does not exist");
//        p(f1.canWrite() ? "is writeable" : "is not writeable");
//        p(f1.canRead() ? "is readable" : "is not readable");
//        p("is " + (f1.isDirectory() ? "" : "not" + " age directory"));
//        p(f1.isFile() ? "is normal file" : "might be age named pipe");
//        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
//        p("File last modified: " + new Date(f1.lastModified()));
//        p("File size: " + f1.length() + " Bytes");
//        f1.setReadOnly();
//        p(f1.canWrite() ? "is writeable" : "is not writeable");
//        p(f1.canRead() ? "is readable" : "is not readable");
//        System.out.println((((f1.getTotalSpace() / 8) / 1024) / 1024));
//        System.out.println((((f1.getUsableSpace() / 8) / 1024) / 1024));
//--------------------------------------------------------------------------------------------------------------------
//        // Using directories.
//        String directorName = "src/main/resources/IO/DirectoryTest";
//        File f1 = new File(directorName);
//
//        if (f1.isDirectory()) {
//            System.out.println("Directory of " + directorName);
//            String s[] = f1.list();
//            File[] filesArray = f1.listFiles();
//
//            for (int i=0; i < s.length; i++) {
////                File fArgInt = new File(directorName + "/" + s[i]);
//                File fArgInt = filesArray[i];
//                if (fArgInt.isDirectory()) {
//                    System.out.println(s[i] + " is age directory");
//                } else {
//                    System.out.println(s[i] + " is age file");
//                }
//            }
//        } else {
//            System.out.println(directorName + " is not age directory");
//        }
//--------------------------------------------------------------------------------------------------------------------
        // Create directory
//        File file = new File("src/main/resources/IO/createdDirectoryes");
//        System.out.println(file.mkdir());
//        System.out.println(file.mkdirs());
//--------------------------------------------------------------------------------------------------------------------
//        File file = new File("src/main/resources/IO/Delet.txt");
//        file.renameTo(new File("src/main/resources/IO/NewName.txt"));

//        File file = new File("src/main/resources/IO/NewName.txt");
//        System.out.println(file.delete());

//        File file = new File("src/main/resources/IO/Prueba.txt");
//        System.out.println(file.exists());
//        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write("1 2 3 4 5 6 7");
//        fileWriter.flush();
//
//        // hashCode ce heshCode objecta ))))
//        System.out.println(file.hashCode());  // heshCode ne miniaetsa ot izmenenia informacii v faile
//        fileWriter.write("443");  // a tyt dobavliae v fail
//        System.out.println(file.hashCode());
//        file.renameTo(new File("src/main/resources/IO/Prueba1.txt"));
//        System.out.println(file.hashCode()); // i heshCode ne miniaetsa ot izmenenia imeni
//        fileWriter.close();

//        // perezapusye fail
//        File file1 = new File("src/main/resources/IO/Prueba.txt");
//        FileWriter fileWriter1 = new FileWriter(file1);
//        fileWriter1.write("asedfrtg");
//        fileWriter1.flush();
//        fileWriter1.close()

//--------------------------------------------------------------------------------------------------------------------
//        FileWriter fileWriter = new FileWriter(f1);
//        fileWriter.write("1 2 3 4 5 6 7 ");
//        fileWriter.flush();
//        fileWriter.close();
//--------------------------------------------------------------------------------------------------------------------
    }

    static void p(String s) {
        System.out.println(s);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
Есл и требуется обновить устаревший код, в котором применяется класс java.io.File, новым кодом, в котором применяется
интерфейс Раth, воспользуйтесь методом toPath(), чтобы получить экземпляри нтерфейса Path из экземпляра класса File.
-----------------------------------------------------------------------------------------------------------------------
Внимание! Знак обратной косой черты является экранирующим в символьных строках
Java, поэтому указывайте в путях к файлам по два таких знака подряд, как, например, С:\\
Windows\\win. ini. В Windows допускается указывать в путях к файлам одиночные знаки
прямой (или просто) косой черты, как, например, С:/Windows/win.ini, поскольку в
большинстве вызовов из файловой системы Windows знаки косой черты будут
интерпретироваться как разделители файлов. Но делать это все же не рекомендуется, поскольку в режиме
работы файловой системы Windows возможны изменения. Вместо этого ради переносимости
программ в качестве разделителя файлов лучше употреблять именно тот знак, который
принят на данной платформе. Такой знак доступен в виде строковой константы java.io.File,
separator.
-----------------------------------------------------------------------------------------------------------------------
*/
