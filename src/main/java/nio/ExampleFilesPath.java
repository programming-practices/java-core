package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ExampleFilesPath {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/nio/tempFile.txt");
        Path path = Paths.get("src/main/resources/nio/tempPath.txt");//file.toPath().toAbsolutePath();
        Files files;

//        file.exists();
//        file.createNewFile();
//        file.delete();
//
//        System.out.println("path.getFileName() = " + path.getFileName());
//        System.out.println("path.getFileSystem() = " + path.getFileSystem());
//        System.out.println("path.getRoot() = " + path.getRoot());
//        System.out.println("path.getParant() = " + path.getParent());
//        System.out.println("path.getName() = " + path.getName(0));
//        System.out.println("path.isAbsolute() = " + path.isAbsolute());
//        System.out.println("path.getNameCount() = " + path.getNameCount());
//
//        File fArgInt = path.toFile();
//---------------------------------------------------------------------------------------------------------------------
//        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/nio/temp1.txt"));
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(bytes[i] + ", ");
//        }
//        System.out.println("\n");
//        String str = new String(bytes);
//        System.out.println("------str-------");
//        System.out.println(str);
//        System.out.println("------str-------");
//----------------------------------------------------------------------------------------------------------------------
//        List<String> list = Files.readAllLines(Paths.get("src/main/resources/nio/temp1.txt"));
//        list.forEach(System.out::print);
//----------------------------------------------------------------------------------------------------------------------
//        Files.write(path, "1bla1haha\n".getBytes());
//        Files.write(path, "2bla2haha\n".getBytes(), StandardOpenOption.APPEND);
//        Files.write(path, "3bla\n3haha".getBytes(), StandardOpenOption.WRITE); // ostorozno z WRITE
//---------------------------------------------------------------------------------------------------------------------
//        List<String> list1 = new ArrayList<String>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        Files.write(path, list1);
//---------------------------------------------------------------------------------------------------------------------
//        InputStream inputStream = Files.newInputStream(path);
//        OutputStream outputStream = Files.newOutputStream(path);
//---------------------------------------------------------------------------------------------------------------------
//        Reader reader = Files.newBufferedReader(path);
//        Writer writer = Files.newBufferedWriter(path);
//--------------------------------------------------------------------------------------------------------------------
        Files.createDirectories(Paths.get("src/main/resources/nio"));
        Files.createFile(Paths.get("src/main/resources/nio/RRR.txt"));
//---------------------------------------------------------------------------------------------------------------------
//        Path tmpPth = Files.createTempFile("src/main/resources/nio/max", "txt");
//        Path tmpPth2 = Files.createTempDirectory("src/main/resources/nio/temp");
//        System.out.println(tmpPth);
//        System.out.println(tmpPth2);
//--------------------------------------------------------------------------------------------------------------------

//        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("."))) {
//            for(Path path1 : entries) {
//                System.out.println(path1.getFileName());
//            }
//        }
//---------------------------------------------------------------------------------------------------------------------
//        Files.isSameFile(path, path);
//        Files.isDirectory(path);
//        Files.isReadable(path);
//        Files.isExecutable(path);
//        Files.isWritable(path);
//        System.out.println(Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS));
//        Files.size(path);
//        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
//        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
//        attributes.creationTime();
//
//        Path path2 = Paths.get("src/main/resources/nio/new.txt");
//        Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
//        Files.move(path2, Paths.get("src/main/resources/nio/old.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.delete(Paths.get("src/main/resources/nio/old.txt"));
//        Files.deleteIfExists(Paths.get("src/main/resources/nio/old.txt"));
//        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new MyFileVisitor());
//---------------------------------------------------------------------------------------------------------------------
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
