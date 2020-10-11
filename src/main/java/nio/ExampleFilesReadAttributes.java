package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ExampleFilesReadAttributes {
    public static void main(String args[]) {
        // Absolute path
        Path filePath = Paths.get("src/main/resources/nio/ExampleFilesReadAttributes.txt");
        // Not absolute path
//        Path filepath = Paths.get("src/main/resources/nio/ExamplePath.txt");

        try {
            /*Другие атрибуты файлов получаются по запросу из спис юi , создаваемого п ри
            вызове метода F i l e s . readAt t r ibut e s ( ) . В рассматриваемом здесь примере про­
            граммы этот метод вызывается для получения связанного с файлом объекта т ипа
            B a s i c Fi leAt t r ibut e s , но аналогичный общий подход можно применить и к другим типам атрибутов.
            */
            BasicFileAttributes attribs = Files.readAttributes(filePath, BasicFileAttributes.class);
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
