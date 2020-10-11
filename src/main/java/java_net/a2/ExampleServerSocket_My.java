package java_net.a2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExampleServerSocket_My {

    public static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server starting, waiting for connection.");
//            serverSocket.setSoTimeout(10_000);
            int contWorkers = 1;

            while (true) {

//                synchronized (ExampleClientSocket_My.class) {
//                    try {
                Socket socketIncoming = serverSocket.accept();
                System.out.println("Client numer #" + contWorkers +
                        " socket accepted: " + socketIncoming.getInetAddress());

                Runnable runnable = new ThreadedEchoHandler(socketIncoming);
                Thread thread = new Thread(runnable);
                thread.start();
                contWorkers++;
//                    }
//                }
            }
        }/*catch (SocketTimeoutException e){
            System.out.println("Time out from waiting. Server closed!!!");
        }*/ catch (IllegalArgumentException e) {
            System.out.println("Port is incorect");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket) {
        incoming = incomingSocket;
    }

    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream()) {

            byte[] buffer = new byte[32 * 1024];
            int readBytes = inStream.read(buffer);
            String lines = new String(buffer, 0, readBytes);
            System.out.println("Received from the client: " + lines);

            outStream.write(lines.toUpperCase().getBytes());
            outStream.flush();
            /*Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"),
                    true *//* autoFlush *//*);

            out.println( "Hello! Enter BYE to exit." );

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Received from the client: " + line);
                out.println("Echo: " + line.toUpperCase());
                if (line.trim().equals("BYE"))
                    done = true;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
