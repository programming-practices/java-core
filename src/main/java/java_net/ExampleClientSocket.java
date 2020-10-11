package java_net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExampleClientSocket {
    //---------------------------------------------------------------------------------------------------------------------
    public static final int PORT = 19000;
    public static final String HOST = "localhost";

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT)) {

            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {

                String str = "Hello";
                outputStream.write(str.getBytes());
                outputStream.flush();
//                System.out.println("Sent the value: \"" + str + "\" to the Server.");
                System.out.println("Sent the value to the Server.");

                byte[] buffer = new byte[32 * 1024];
                int readBytes = inputStream.read(buffer);
                System.out.println("Respons Server: " + new String(buffer, 0, readBytes));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
//--------------------------------------------------------------------------------------------------------------------
}
