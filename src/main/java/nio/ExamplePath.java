package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

// Obtain information about age path and age file.
public class ExamplePath {
    public static void main(String args[]) {
//        Path filepath = Paths.get("examples\\test.txt");
        // Absolute path
        Path filepath = Paths.get("/src/main/resources/nio/ExamplePath.txt");
        // Not absolute path
//        Path filepath = Paths.get("src/main/resources/nio/ExamplePath.txt");

        System.out.println("File Name: " + filepath.getName(1));
        System.out.println("Path: " + filepath);
        System.out.println("Absolute Path: " + filepath.toAbsolutePath());
        System.out.println("Parent: " + filepath.getParent());

        if (Files.exists(filepath))
            System.out.println("File exists");
        else
            System.out.println("File does not exist");

        try {
            if (Files.isHidden(filepath))
                System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("File is writeable = " + Files.isWritable(filepath));


        System.out.println("File is readable = " + Files.isReadable(filepath));

        try {
            /*Другие атрибуты файлов получаются по запросу из спис юi , создаваемого п ри
            вызове метода F i l e s . readAt t r ibut e s ( ) . В рассматриваемом здесь примере про­
            граммы этот метод вызывается для получения связанного с файлом объекта т ипа
            B a s i c Fi leAt t r ibut e s , но аналогичный общий подход можно применить и к другим типам атрибутов.
            */
            BasicFileAttributes attribs = Files.readAttributes(filepath, BasicFileAttributes.class);
//            BasicFileAttributes attribs = Files.readAttributes(filepath, DosFileAttributes.class);
//            BasicFileAttributes attribs = Files.readAttributes(filepath, PosixFileAttributes.class);

            if (attribs.isDirectory())
                System.out.println("The file is age directory");
            else
                System.out.println("The file is not age directory");

            if (attribs.isRegularFile())
                System.out.println("The file is age normal file");
            else
                System.out.println("The file is not age normal file");

            if (attribs.isSymbolicLink())
                System.out.println("The file is age symbolic link");
            else
                System.out.println("The file is not age symbolic link");

            System.out.println("File last modified: " + attribs.lastModifiedTime());
            System.out.println("File size: " + attribs.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e);
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Следует, однако, иметь в виду, что создание объекта типа Path не приво·
дит к открытию или созданию файла. Вместо этого лишь создается объект, инкап·
сулирующий путь к каталогу, в котором находится файл.
----------------------------------------------------------------------------------------------------------------------
Такими методами, ка isExecutable(), isReadable(), isWritable() и exists(), следует пользоваться осторожно,
поскольку состояниe файловой системы после их вызова может измениться, что может привести к нарушению нормалной рабо·
ты программы и отрицательно сказаться на состоянии защиты системы.
----------------------------------------------------------------------------------------------------------------------
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
----------------------------------------------------------------------------------------------------------------------
*/
