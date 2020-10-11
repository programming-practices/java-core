package java_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a simple server that listens to port 8189 and echoes back all client
 * input.
 *
 * @author Cay Horstmann
 * @version 1.21 2012-05-19
 */
public class ExampleServerSocket_Cay_Horstmann {
    public static void main(String[] args) throws IOException {
        // establish server socket
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            // wait for client connection
            try (Socket incoming = serverSocket.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),
                            true /* autoFlush */);

                    out.println("Hello! Enter BYE to exit.");

                    // echo client input
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line.toUpperCase());
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
nado snachale zapystit server a potom v konsoli zpystit telnet localhost 8189
----------------------------------------------------------------------------------------------------------------------
• ServerSocket(int port)
   Создает сокет на стороне сервера, контролирующего указанный порт.

• Socket accept()
   Ожидает соединения. Этот метод блокирует (т.е. переводит в режим ожидания) текущий поток
   до тех пор, пока не будет установлено соединение. Возвращает объект типа Socket, через
   который программа может взаимодействовать с подключаемым клиентом.

• void close()
   Закрывает сокет на стороне сервера.
----------------------------------------------------------------------------------------------------------------------
*/