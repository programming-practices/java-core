package java_net.a2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExampleClientSocket_My {
    private final String HOST;
    private final int PORT;

    public ExampleClientSocket_My(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
    }


    public /*synchronized*/ void startClient() {

        try (Socket socket = new Socket(HOST, PORT)) {

            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {

//                String str = "Hello12";
                String str = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has " +
                        "roots in a piece of classical Latin literature from 45 BC, making it over 2000 " +
                        "years old. Richard McClintock, a Latin professor at Hampden-Sydney College in " +
                        "Virginia, looked up one of the more obscure Latin words, consectetur, from a " +
                        "Lorem Ipsum passage, and going through the cites of the word in classical " +
                        "literature, discovered the undoubtable source. Lorem Ipsum comes from sections " +
                        "1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good " +
                        "and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of " +
                        "ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
                        "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";
                outputStream.write(str.getBytes());
                outputStream.flush();
//                System.out.println("Sent the value: \"" + str + "\" to the Server.");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Sent the value to the Server.");

                byte[] buffer = new byte[32 * 1024];
                int readBytes = inputStream.read(buffer);
                System.out.println("Respons Server: " + new String(buffer, 0, readBytes));
                System.out.println("-------------------------------------------------------------------------");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
