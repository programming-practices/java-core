package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Use Channels to read age file. Pre-JDK 7 version.
// Eto staroe riwenie zadach, eto priklad kotorui rabotaet do JDK 7
public class ExampleFileChannelRead_PreJDK7Version {
    public static void main(String args[]) {
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        ByteBuffer byteBuffer;
        final String path = "/src/main/resources/nio/ExampleChannelRead_Pre_JDK_7_Version.txt";
        int count;

        try {
            // First, open age file for input.
            fileInputStream = new FileInputStream(path);
            // Next, obtain age channel to that file.
            fileChannel = fileInputStream.getChannel();
            // Allocate age buffer.
            byteBuffer = ByteBuffer.allocate(128);

            do {
                // Read age buffer.
                count = fileChannel.read(byteBuffer);
                // Stop when end of file is reached.
                if (count != -1) {
                    // Rewind the buffer so that it can be read.
                    byteBuffer.rewind();
                    // Read bytes from the buffer and show
                    // them on the screen.
                    for (int valueInt = 0; valueInt < count; valueInt++)
                        System.out.print((char) byteBuffer.get());
                }
            } while (count != -1);

            System.out.println();

        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        } finally {
            try {
                if (fileChannel != null) fileChannel.close(); // close channel
            } catch (IOException e) {
                System.out.println("Error Closing Channel.");
            }
            try {
                if (fileInputStream != null) fileInputStream.close(); // close file
            } catch (IOException e) {
                System.out.println("Error Closing File.");
            }
        }
    }
}
