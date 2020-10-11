package java_net.a1;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {
    public static void main(String[] args) {
        MarcoServidor marcoServidor = new MarcoServidor();
        marcoServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoServidor extends JFrame implements Runnable {
    private ServerSocket serverSocket;
    private Socket socketRecibirPaquete;
    private Socket socketEnviarPaquete;
    private Paquete paqueteRecibido;
    private ObjectInputStream objectInputStreamRecibido;
    private ObjectOutputStream objectOutputStreamEnviar;

    public MarcoServidor() {
//        setBounds(1200, 300, 280, 350);
//        JPanel milamina = new JPanel();
//        milamina.setLayout(new BorderLayout());
//        jTextArea = new JTextArea();
//        milamina.add(jTextArea, BorderLayout.CENTER);
//        add(milamina);
//        setVisible(true);
        Thread myThread = new Thread(this);
        myThread.start();
    }

    public void recibirPaquete() {
        try {
            serverSocket = new ServerSocket(989);
            socketRecibirPaquete = serverSocket.accept();
            objectInputStreamRecibido = new ObjectInputStream(socketRecibirPaquete.getInputStream());
            paqueteRecibido = (Paquete) objectInputStreamRecibido.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void enviarPaquete() {
        try {
            socketEnviarPaquete = new Socket(paqueteRecibido.getIpDestination(), 980);
            objectOutputStreamEnviar = new ObjectOutputStream(socketEnviarPaquete.getOutputStream());
            objectOutputStreamEnviar.writeObject(paqueteRecibido);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                recibirPaquete();
                enviarPaquete();
            }
        } finally {
            try {
                objectInputStreamRecibido.close();
                socketRecibirPaquete.close();
                serverSocket.close();
                objectOutputStreamEnviar.close();
                socketEnviarPaquete.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
