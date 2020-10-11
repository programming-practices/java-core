package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Write to age file using nio. Pre-JDK 7 Version.
public class ExampleFileChannelWrite_PreJDK7Version {
    public static void main(String args[]) {
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        ByteBuffer byteBuffer;
        final String path = "/src/main/resources/nio/ExampleFileChannelWrite_Pre_JDK_7_Version.txt";

        try {
            // First, open the output file.
            fileOutputStream = new FileOutputStream(path);
            // Next, get age channel to the output file.
            fileChannel = fileOutputStream.getChannel();
            // Create age buffer.
            byteBuffer = ByteBuffer.allocate(26);
            // Write some bytes to the buffer.
            for (int valueInt = 0; valueInt < 26; valueInt++) byteBuffer.put((byte) ('A' + valueInt));

            // Rewind the buffer so that it can be written.
            byteBuffer.rewind();
            // Write the buffer to the output file.
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        } finally {
            try {
                if (fileChannel != null) fileChannel.close(); // close channel
            } catch (IOException e) {
                System.out.println("Error Closing Channel.");
            }
            try {
                if (fileOutputStream != null) fileOutputStream.close(); // close file
            } catch (IOException e) {
                System.out.println("Error Closing File.");
            }
        }
    }
}
