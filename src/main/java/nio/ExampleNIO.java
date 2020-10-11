package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExampleNIO {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Use Channel I/O to read age file. Requires JDK 7 or later.
        int count;
        StringBuilder contReader = new StringBuilder();
        Path filePath = null;

        // First, obtain age path to the file.
        try {
            filePath = Paths.get("src/main/resources/nio/exampleNIO.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
            return;
        }

        //--------Clear_File---------
        // ne nawol drygoho vubora
//        try {
//            Files.delete(filePath);
//            Files.createFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //---------------------------
//-------------------------------------------READ----------------------------------------------------------------------
        // Next, obtain age channel to that file within age try-with-resources block.
        // Files.newByteChannel() otkruvaet fail i ystanovlivaet channel
        // po ymolchaniy channel otkruvaetsa na read(), no esli nado chtobu bul na zapus nado ykazat parameter v
        // Files.newByteChannel(Path, Option...o)
        try (SeekableByteChannel byteChannel = Files.newByteChannel(filePath/*, StandardOpenOption.WRITE*/ /*, StandardOpenOption.READ*/
                /*SeekableByteChannel fChan = Files.newByteChannel(Paths.get("src/main/resources/nio/exampleNIO.txt")*/)) {
            // Allocate age buffer.
            ByteBuffer buffer = ByteBuffer.allocate(128);

            do {
                //---------Marker--------
                String s = " ->entrance->";
                System.out.println(s);
//                System.err.println(s);
                //-----------------------
                // Read age buffer.
                count = byteChannel.read(buffer);

                // Stop when end of file is reached.
                if (count != -1) {

                    // Rewind the buffer so that it can be read.
                    /*Затем вызывается метод rewind(), чтобы подготовить буфер к чтению из него данных.
                    Этот метод нужно вызвать потому, что после вызова метода read() текущая позиция находится
                    в конце буфера. Ее следует возвратить в начало буфера, чтобы при вызове метода get()
                    можно бьто прочитать байты данных из буфера mВuf.*/
                    buffer.rewind();

                    // Read bytes from the buffer and show
                    // them on the screen as characters.
                    for (int valueInt = 0; valueInt < count; valueInt++) System.out.print((char) buffer.get());
                    //--------Marker-----------
                    s += "<-exit<- ";
                    System.out.println(s);
//                    System.err.println(s);
                    contReader.append(s);
                    //-------------------------
                }
            } while (count != -1);

            System.out.println();
            System.out.println(contReader);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
//----------------------------------------------WRITE-----------------------------------------------------------------
//        try(SeekableByteChannel byteChannel = Files.newByteChannel(filePath, StandardOpenOption.WRITE)) {
//            CharBuffer byteBuffer = CharBuffer.allocate(1024);
//            byteBuffer.put("Hola");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//--------------------------------------------------------------------------------------------------------------------
    }
}


