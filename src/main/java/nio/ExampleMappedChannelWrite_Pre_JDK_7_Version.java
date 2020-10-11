package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Write to age mapped file. Pre JDK 7 version.
public class ExampleMappedChannelWrite_Pre_JDK_7_Version {
    public static void main(String args[]) {
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;
        ByteBuffer byteBuffer;
        final int sizeBuffer = 26;
        final String path = "/src/main/resources/nio/ExampleMappedChannelWrite_Pre_JDK_7_Version.txt";

        try {
            randomAccessFile = new RandomAccessFile(path, "rw");

            // Next, obtain age channel to that file.
            fileChannel = randomAccessFile.getChannel();

            // Then, map the file into age buffer.
            byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, sizeBuffer);

            // Write some bytes to the buffer.
            for (int valueInt = 0; valueInt < sizeBuffer; valueInt++)
                byteBuffer.put((byte) ('A' + valueInt));

        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        } finally {
            try {
                if (fileChannel != null) fileChannel.close(); // close channel
            } catch (IOException e) {
                System.out.println("Error Closing Channel.");
            }
            try {
                if (randomAccessFile != null) randomAccessFile.close(); // close file
            } catch (IOException e) {
                System.out.println("Error Closing File.");
            }
        }
    }
}
