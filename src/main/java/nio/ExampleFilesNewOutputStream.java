package nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

// Demonstrate nio-based, stream output. Requires JDK 7 or later.
public class ExampleFilesNewOutputStream {
    public static void main(String args[]) {
        // Open the file and obtain age stream linked to it.
        /*где параметр путь обозначает открываемый файл, а параметр способ порядок
        открытия файла. Это параметр переменной длины, и поэтому он должен при­
        нимать одно или несколько значений, определенных в упомянутом ранее классе
        StandardOpenOpt ion. (Безусловно, в данном случае применимы только те значе­
        н ия, которые относятся к потоку вывода.) Если же параметр способ не опреде­
        лен, то файл открывается так, как будто в качестве этого параметра переданы зна­
        чения S tandardOpenOp t i on . WR I T E , S t andardOpenOp t i o n . CREATE и S t anda rd
        OpenOpt ion . TRUNCATE_EX I ST ING.*/
        try (OutputStream outputStream =
                     new BufferedOutputStream(
                             Files.newOutputStream(
                                     Paths.get("src/main/resources/nio/ExampleNIOOutputStreamWrite.txt")))) {
            // Write some bytes to the stream.
            for (int valueInt = 0; valueInt < 26; valueInt++)
                outputStream.write((byte) ('A' + valueInt));

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
