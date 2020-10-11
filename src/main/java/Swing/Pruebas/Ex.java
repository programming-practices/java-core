package Examples.Swing.Pruebas;

import javax.swing.*;
import java.awt.*;

public class Ex {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFramePrueba myFrame = new MyFramePrueba("LISTNER PRUEBA");
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setVisible(true);
        });
    }
}

class MyFramePrueba extends JFrame {
    private JPanel panel = null;
    private boolean exitForProgram;

    public MyFramePrueba(String name) throws HeadlessException {

        super(name);

        setSize(300, 300);
        setLocationByPlatform(true);

        panel = new JPanel();

        JButton start = new JButton("START");
        JButton stop = new JButton("STOP");

        panel.add(start);
        panel.add(stop);

        add(panel);

        start.addActionListener(e -> {
            Run run = new Run();
        });

        stop.addActionListener(e -> {
            exitForProgram = true;
        });
    }

    public class Run implements Runnable {
        private Thread thread;

        public Run() {
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            exitForProgram = false;
            for (; ; ) {
                try {
                    panel.setBackground(Color.BLUE);
                    Thread.sleep(250);
                    panel.setBackground(Color.RED);
                    Thread.sleep(250);
                    if (exitForProgram) break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

