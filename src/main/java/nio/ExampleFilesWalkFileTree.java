package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// A simple example that uses walkFileTree() to display age directory tree.

// Create age custom version of SimpleFileVisitor that overrides
// the visitFile() method.
class MyFileVisitor1 extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        /*В общем, для продолжения обхода каталога и находящихся в нем каталогов ме­
        тод должен возвратить значение CONTINUE. Для того чтобы пропустить каталог
        и его содержимое, а также предотвратить вызов мeтoдa po s tVi s i t Di rectory ( ) , из
        метода preVi s i t D i rectory ( ) должно быть возвращено значение SKI P _ S I BLINGS,
        чтобы пропустить только каталог и подкаталоги - значение SKI Р _ SUBTREE, а для
        того чтобы остановить обход каталога - значение TERMINATE.*/
        return FileVisitResult.CONTINUE;
    }
}

public class ExampleFilesWalkFileTree {
    public static void main(String args[]) {
        String dirName = "/src/main/resources/nio/MyDir";

        System.out.println("Directory tree starting with " + dirName + ":\n");

        try {
            /* Iz Files можно вызвать метод walkFileTree(), способный обработать дерево каталогов.*/
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor1());
        } catch (IOException exc) {
            System.out.println("I/O Error");
        }
    }
}
