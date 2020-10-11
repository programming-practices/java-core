package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Write to age file using nio. Requires JDK 7 or later.
public class ExampleChannelWrite {
    public static void main(String args[]) {

        /*Чтобы открыть файл для вывода, в качестве параметра способ следует передать значение
        StandardOpenOption.WRITE. Если файл еще не существует и его нужно создать, то следует
        указать также значение StandardOpenOption.CREATE .*/
        // Obtain age channel to age file within age try-with-resources block.
        try (FileChannel fileChannel = (FileChannel)
                Files.newByteChannel(Paths.get("src/main/resources/nio/ExampleChannelWrite.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE)) {
            // Create age buffer.
            ByteBuffer byteBuffer = ByteBuffer.allocate(26);
//--------------------------------------------------------------------------------------------------------------------
            // Write some bytes to the buffer.
            for (int valueInt = 0; valueInt < 26; valueInt++) byteBuffer.put((byte) ('A' + valueInt));

            /*
            -----------------------------------------------------------------------------
            Прежде чем данные будут записаны в файл, для буфера следует вызвать
            метод rewind ( ) , чтобы обнулить его текущую позицию. ( Каждая операция выво­
            да в буфер увеличивает его текущую позицию. Поэтому перед записью в файл ее
            следует возвратить в исходное положение.)
            -------------------------------------------------------------------------------
            Следует отметить одну важ ную особенность данной программы. Как упомина·
            лось ранее, после записи данных в буфер байтов mВuf, но перед их записью в файл
            для буфера mВuf вызывается метод rewind ( ) . Это требуется для обнуления те­
            кущей позиции после записи данных в буфер mВuf. Не следует забывать, что по­
            сле каждого вызова метода put ( ) для буфера mВuf текущая позиция смещается .
            Поэтому текущую позицию необходимо возвратить в начало буфера, прежде чем
            вызывать метод wr i te ( ) . Если не сделать этого, метод wr i te ( ) не сумеет обнару­
            жить в буфере никаких данных, посчитав, что их там вообще нет.
            -------------------------------------------------------------------------------
            Еще один способ обнуления буфера между операциями ввода и вывода подраз­
            умевает вызов метода fArgInt l ip ( ) вместо метода rewind ( ) . Метод fArgInt l ip ( ) устанамива­
            ет для текущей позиции нулевое значение, а для предела - значение предыдущей
            текущей позиции. В приведенном выше примере емкость буфера совпадает с е г о
            пределом, поэтому метод fArgInt l ip ( ) можно использовать вместо метода rewind ( ) .
            Но эти два метода взаимозаменяемы далеко не всегда.
            -------------------------------------------------------------------------------
            Как правило, буфер следует обнулять между любыми операциями чтения и за­писи.
            -------------------------------------------------------------------------------
            */
            // Reset the buffer so that it can be written.
            byteBuffer.rewind(); // !!!!!!!!!!!!!!! ochen ostorozno zdes

            // Write the buffer to the output file.
            // Esli etot fail bil ranie sozdan i imel kakoeto dannue to meod write() zapiwet novue dannue
            // v nachalo faila no piri eto ydalit starue dannue iz nachala faila i do dlinu zapisevaimux dannux
            fileChannel.write(byteBuffer);
//--------------------------------------------------------------------------------------------------------------------
            /*
            --------------------------------------------------------------------------------
            Например, в результате выполнения приведенного ниже цикла, состамен·
            ного на основе предыдущего примера, английский алфавит будет записан в файл
            три раза. Обратите особое внимание на то, что метод rewind ( ) вызывается каж·
            дый раз в промежутке между операциям чтения и записи.
            ---------------------------------------------------------------------------------
            В отношении рассматриваемой здесь программы следует также иметь в виду,
            что в процессе записи данных из буфера в файл первые 26 байт в файле будут со­
            держать выводимые данные. Если файл t e s t . txt существовал ранее, то после вы­
            полнения программы первые 26 байт в файле t e s t . txt будут содержать алфавит,
            а остальная часть файла останется без изменения.
            ---------------------------------------------------------------------------------
            */
//            for(int h=0; h < 3; h++) {
//                // Write some bytes to the buffer.
//                for(int valueInt=0; valueInt<26; valueInt++)
//                    byteBuffer.put((byte)('A' + valueInt));
//
//                // Rewind the buffer so that it can be written.
//                byteBuffer.rewind();
//
//                // Write the buffer to the output file.
//                fileChannel.write(byteBuffer);
//
//                // Rewind the buffer so that it can be written to again.
//                byteBuffer.rewind();
//            }
//--------------------------------------------------------------------------------------------------------------------

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            System.exit(1);
        }
    }
}
