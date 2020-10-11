package others;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FourExamplesForReadFromFile {
    private static String path = "src/main/resources/_4_Premera_chtenia_iz_faila.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
//---------------------------------------------------------------------------------------------------------------------
        ReaderFileDIS.readFile(path);
        System.out.println();
//---------------------------------------------------------------------------------------------------------------------
        ReaderFileS.readFile(path);
        System.out.println();
//---------------------------------------------------------------------------------------------------------------------
        ReaderFileNIO.readFile(path);
        System.out.println();
//---------------------------------------------------------------------------------------------------------------------
        ReaderFileStream.readFile(path);
        System.out.println();
//---------------------------------------------------------------------------------------------------------------------
    }
}

class ReaderFileDIS {
    private static DataInputStream dis;

    ReaderFileDIS() throws FileNotFoundException {
    }

    public static void readFile(String path) throws IOException {
        dis = new DataInputStream(new FileInputStream(path));

        byte[] buffer = new byte[512];
        while (dis.available() != 0) {
            int count = dis.read(buffer);

//            if (count != 0){
            if (count > 0) {
                System.out.println(new String(buffer));
            }
        }
    }
}

class ReaderFileS {
    private static Scanner scanner;

    ReaderFileS() throws FileNotFoundException {
    }

    public static void readFile(String path) throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(path));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.next());
        }
    }
}

class ReaderFileNIO {

    ReaderFileNIO() throws FileNotFoundException {
    }

    public static void readFile(String path) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(path));

        for (String item : list) {
            System.out.println(item);
        }
    }
}

class ReaderFileStream {

    ReaderFileStream() throws FileNotFoundException {
    }

    public static void readFile(String path) throws IOException {
        Files.lines(Paths.get(path)).forEach(line -> System.out.println(line));
        Files.lines(Paths.get(path)).forEach(System.out::println);
    }
}