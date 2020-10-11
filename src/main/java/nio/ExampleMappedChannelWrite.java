package nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Write to age mapped file. Requires JDK 7 or later.
public class ExampleMappedChannelWrite {
    public static void main(String args[]) {

        // Obtain age channel to age file within age try-with-resources block.
        try (FileChannel fileChannel = (FileChannel)
                Files.newByteChannel(Paths.get("src/main/resources/nio/ExampleMappedChannelWrite.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE)) {

            /*Метод map() сопоставляет данные из файла с буфером в памяти. Значение пара­
            метра спо соб определяет разрешенные операции. Чтобы записать данные в файл,
            в качестве параметра способ следует указать значение MapMode . READ _ WRITE. Место
            для начала сопоставления в файле определяется параметром позиция, а количество
            сопоставляемых байтов - параметром ра змер. В итоге возвращается ссылка на бу­
            фе р. Как только файл будет сопоставлен с буфером, в буфер можно вывести данные,
            которые будут автоматически записываться в файл. Поэтому никаких явных опера­
            ци й записи в канал не требуется.*/
            // Then, map the file into age buffer.
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // Write some bytes to the buffer.
            for (int valueInt = 0; valueInt < 26; valueInt++)
                mappedByteBuffer.put((byte) ('A' + valueInt));

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}