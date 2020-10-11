package java_net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExampleSocket_Blocing_IO {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.write("1234");

        Server server = new Server();
        server.echo();

        client.read();
    }
}


class Client {

    Socket socket = new Socket("localhost", 8080);
    OutputStream outputStream = socket.getOutputStream();
    InputStream inputStream = socket.getInputStream();

    Client() throws IOException {
    }

    public void write(String value) throws IOException {
        outputStream.write(value.getBytes());
    }

    public void read() throws IOException {
        int data;
        while ((data = inputStream.read()) != -1) {
            System.out.println(data);
        }
    }
}

class Server {

    ServerSocket serverSocket = new ServerSocket(8080);
    Socket socket = serverSocket.accept();
    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();

    int data;

    Server() throws IOException {
    }

    public void echo() throws IOException {
        while ((data = inputStream.read()) == -1) {
            data += 1;
            outputStream.write(data);
        }
    }
}