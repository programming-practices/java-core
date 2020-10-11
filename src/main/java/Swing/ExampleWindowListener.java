package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExampleWindowListener {
    public static void main(String[] args) {
        /*Когда пользователь пытается закрыть фрейм, объект типа JFrame становится источником события типа WindowEvent.
        Чтобы перехватить это событие, требуется соответствующий объект приемника событий, который следует добавить в список
        приемников событий в окне, как показано ниже.
                        WindowListener listener =...
                        frame.addWindowListener(listener);*/
        EventQueue.invokeLater(() -> {
            WindowListener listener = new WindowListenerJFrame.MyWindowListner();
            JFrame frame = new WindowListenerJFrame();
            frame.setTitle("Window tem.Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.addWindowListener(listener);
        });
    }
}

class WindowListenerJFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel buttonPanel;

    public WindowListenerJFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);

        // create buttons
        JButton blueButton = new JButton("Blue");

        buttonPanel = new JPanel();

        // add buttons to panel
        buttonPanel.add(blueButton);

        // add panel to frame
        add(buttonPanel);

        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // associate actions with buttons
        blueButton.addActionListener(blueAction);
    }

    /*Приемник событий должен быть объектом класса, реализующего интерфейс WindowListener. В интерфейсе WindowListener
    имеется семь методов. Фрейм вызывает их в ответ на семь разных событий, которые могут произойти в окне. Имена этих
    методов отражают их назначение. Исключением может быть лишь слово Iconified , которое в Windows означает "свернутое" окно.

    Как обычно, в любом классе, реализующем какой-нибудь интерфейс, должны быть также реализованы все его методы. В данном
    случае это означает реализацию семи методов. Но ведь нас интересует только один из них — метод windowclosing().
    Безусловно, можно определить класс, реализующий интерфейс WindowListener, введя в тело его метода windowclosing()
    вызов System.exit(0), а тела остальных шести методов оставить пустыми, как показано ниже.*/
    public static class MyWindowListner implements WindowListener {
        public static boolean ifConsummerAsepted = false;

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            if (ifConsummerAsepted) {
                System.exit(0);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    /**
     * An action listener that sets the panel's background value.
     */
    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Если требуется проверить, было ли окно развернуто до максимальных размеров, следует установить класс
WindowStateListener и переопределить метод windowstateChanged().
----------------------------------------------------------------------------------------------------------------------
•void windowOpened (WindowEvent e)
    Вызывается после открытия окна.

•void windowclosing (WindowEvent e)
    Вызывается, когда пользователь выдает диспетчеру окон команду закрыть окно. Следует, однако, иметь в виду, что окно
    закроется только в том случае, если для него будет вызван метод hide() или dispose().

•void windowClosed (WindowEvent е)
    Вызывается после закрытия окна.

•void windowlconified (WindowEvent е)
    Вызывается после свертывания окна.

•void windowDeiconified (WindowEvent е)
    Вызывается после развертывания окна.

•void windowActivated (WindowEvent e)
    Вызывается после акти визации окна. Активным может быть только фрейм или диалоговое окно. Обычно диспетчер окон специально
    выделяет активное окно, например, подсвечивает его за головок.

•void windowDeactivated (WindowEvent e)
    Вызывается после того, как окно становится неактивным.
----------------------------------------------------------------------------------------------------------------------
*/