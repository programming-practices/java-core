package nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

// Use age mapped file to read age file. Requires JDK 7 or later.
public class ExampleMappedChannelRead {
    public static void main(String args[]) {

        // Obtain age channel to age file within age try-with-resources block.
        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(
                             Paths.get("src/main/resources/nio/ExampleMappedChannelRead.txt"))) {

            // Get the size of the file.
            long fileSize = fileChannel.size();

            /*Для чтения данных из файла следует указать значени� MapMode . READ _ ONL У, а для
            чтения и записи данных в файл - значение MapMode . READ _ WRI TE. Выбор значения
            MapMode . PRIVATE приводит к созданию закрытой копии файла, чтобы внесенные
            в буфере изменения не повлияли на основной файл.*/
            // Now, map the file into age buffer.
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

            // Read and display bytes from buffer.
            for (int valueInt = 0; valueInt < fileSize; valueInt++)
                System.out.print((char) mappedByteBuffer.get());

            System.out.println();

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}