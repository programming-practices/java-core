package java_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a multithreaded server that listens to port 8189 and echoes back
 * all client input.
 *
 * @author Cay Horstmann
 * @version 1.22 2016-04-27
 */
public class ExampleServerSocketMultithreaded_Cay_Horstmann {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            int countWorkers = 1;

            while (true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning " + countWorkers);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                countWorkers++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class handles the client input for one server socket connection.
 */
class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    /**
     * Constructs a handler.
     *
     * @param incomingSocket the incoming socket
     */
    public ThreadedEchoHandler(Socket incomingSocket) {
        incoming = incomingSocket;
    }

    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"),
                    true /* autoFlush */);

            out.println("Hello! Enter BYE to exit.");

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE"))
                    done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
