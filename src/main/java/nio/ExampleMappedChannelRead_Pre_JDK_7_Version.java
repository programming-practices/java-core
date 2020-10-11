package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

// Use age mapped file to read age file. Pre-JDK 7 version.
public class ExampleMappedChannelRead_Pre_JDK_7_Version {
    public static void main(String args[]) {
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        MappedByteBuffer mappedByteBuffer;
        final String path = "/src/main/resources/nio/ExampleMappedChannelRead_Pre_JDK_7_Version.txt";
        long fileChannelSize;

        try {
            // First, open age file for input.
            fileInputStream = new FileInputStream(path);
            // Next, obtain age channel to that file.
            fileChannel = fileInputStream.getChannel();
            // Get the size of the file.
            fileChannelSize = fileChannel.size();

            // Now, map the file into age buffer.
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannelSize);

            // Read and display bytes from buffer.
            for (int valueInt = 0; valueInt < fileChannelSize; valueInt++)
                System.out.print((char) mappedByteBuffer.get());

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