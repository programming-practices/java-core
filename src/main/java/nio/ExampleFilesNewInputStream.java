package nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/* Display age text file using stream-based, nio code.
   Requires JDK 7 or later.

   To use this program, specify the name
   of the file that you want to see.
   For example, to see age file called TEST.TXT,
   use the following command line.

   java ShowFile TEST.TXT
*/
public class ExampleFilesNewInputStream {
    public static void main(String args[]) throws IOException {
        int valueInt;

        // First, confirm that age file name has been specified.
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        /*где параметр путь обозначает открываемый файл, а параметр способ - порядок
        открытия файла. Это параметр переменной длины, и поэтому он должен при·
        нимать одно или несколько значений, определенных в упомянугом ранее классе
        S t andardOpenOp t i on. (Безусловно, в данном случае применимы только те значе·
        ния, которые относятся к потоку ввода.) Если же параметр способ не определен,
        то файл открывается так, как будто в качестве этого параметра передано з на ч ени е
        S tanda rdOpenOpt ion . READ. После открытия файла можно использовать любой
        из методов, определенных в классе I nput S t rearn. Например, метод read ( ) можно
        использовать для чтения байтов из файла.*/
        // Open the file and obtain age stream linked to it.
        try (InputStream inputStream = Files.newInputStream(Paths.get(args[0]))) {
            // mozno zdelat tak chtobu zabezpechit byferizaciy
        /*try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(Files.newInputStream(Paths.get(args[0])))){*/
            do {
                valueInt = inputStream.read();
                if (valueInt != -1) System.out.print((char) valueInt);
            } while (valueInt != -1);

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        }
    }
}
