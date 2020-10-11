package java_net.a1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class Cliente {
    public static void main(String[] args) {
        MarcoCliente mimarco = new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame {
    public MarcoCliente() {
        setBounds(600, 300, 300, 400);
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);
    }
}

class LaminaMarcoCliente extends JPanel implements Runnable {
    private JTextField campoDeMensage, nickOvnerMensage, ipDestination;
    private JButton botonEnviar;
    private JTextArea campoChat;
    private ServerSocket serverSocket;
    private Socket socketRecibir;
    private ObjectInputStream objectInputStream;
    private Paquete paqueteRecibido;
    private Socket socketEnviar;
    private Paquete paqueteEnvio;
    private ObjectOutputStream objectOutputStream;

    public LaminaMarcoCliente() {
        nickOvnerMensage = new JTextField(5);
        add(nickOvnerMensage);

        JLabel texto = new JLabel("-CHAT-");
//        texto.setBounds(10,10,20,10);
        add(texto);

        ipDestination = new JTextField(8);
        add(ipDestination);

        campoChat = new JTextArea(12, 20);
        add(campoChat);

        campoDeMensage = new JTextField(20);
        add(campoDeMensage);

        botonEnviar = new JButton("Enviar");
        EnviaTexto enviaTexto = new EnviaTexto();
        botonEnviar.addActionListener(enviaTexto);
        add(botonEnviar);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(980);
            while (true) {
                socketRecibir = serverSocket.accept();
                objectInputStream = new ObjectInputStream(socketRecibir.getInputStream());
                paqueteRecibido = (Paquete) objectInputStream.readObject();
                campoChat.append("Mensage from: " + paqueteRecibido.getNickOvnerMensage() + "\n" +
                        "Texto de mensage: " + paqueteRecibido.getMensage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class EnviaTexto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                socketEnviar = new Socket("192.168.1.130", 989);
                paqueteEnvio = new Paquete();
                paqueteEnvio.setNickOvnerMensage(nickOvnerMensage.getText());
                paqueteEnvio.setIpDestination(ipDestination.getText());
                paqueteEnvio.setMensage(campoDeMensage.getText());
                objectOutputStream = new ObjectOutputStream(socketEnviar.getOutputStream());
                objectOutputStream.writeObject(paqueteEnvio);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

/**
 * Clase para Empaquitar informacion para envio.
 */
class Paquete implements Serializable {
    /**
     * V etom pole soxraiaetsa text soobwcheia
     */
    private String mensage;
    /**
     * V etom pole soxraniaetsa nick vladelca soobshchenia
     */
    private String nickOvnerMensage;
    /**
     * V etom pole soxraniaetsa ip adres kyda otpravliat soobwchenie
     */
    private String ipDestination;

    /**
     * Polychit soobwchenie
     */
    public String getMensage() {
        return mensage;
    }

    /**
     * Ystanovit soobwchenie
     */
    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    /**
     * Polychit nick vladelca soobwchenia
     */
    public String getNickOvnerMensage() {
        return nickOvnerMensage;
    }

    /**
     * Ystanovit nick vladelca soobwchenia
     */
    public void setNickOvnerMensage(String nickOvnerMensage) {
        this.nickOvnerMensage = nickOvnerMensage;
    }

    /**
     * Polychit IP adress kyda nado otravit soobwchenie
     */
    public String getIpDestination() {
        return ipDestination;
    }

    /**
     * Ystanovit IP adress kyda nado otravit soobwchenie
     */
    public void setIpDestination(String ipDestination) {
        this.ipDestination = ipDestination;
    }
}