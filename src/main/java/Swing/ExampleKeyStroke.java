package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ExampleKeyStroke {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new KeyStrokeFrame();
            frame.setTitle("ActionTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a panel that demonstrates value change actions.
 */
class KeyStrokeFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String pathYellow_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/yellow-ball.gif";
    private static final String pathBlue_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/blue-ball.gif";
    private static final String pathRed_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/red-ball.gif";
    private JPanel buttonPanel;

    public KeyStrokeFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        // define actions
        Action yellowAction = new ColorAction("Yellow", new ImageIcon(pathYellow_ball), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon(pathBlue_ball), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon(pathRed_ball), Color.RED);

        // add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        // add panel to frame
        add(buttonPanel);

        /*И, наконец, объекты действий нужно связать с клавишами, чтобы эти действия выполнялись, когда пользователь
        нажимает соответствующие клавиши. Для того чтобы связать действия с нажатием клавиш, сначала нужно создать объект
        класса Keystroke. Это удобный класс, инкапсулирующий описание клавиш следующим образом:
                                KeyStroke ctrlBKey = KeyStroke.getKeyStroke("Ctrl В");*/
        // associate the Y, B, and R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction {
        /**
         * Constructs a value action.
         *
         * @param name the name to show on the button
         * @param icon the icon to display on the button
         * @param c    the background value
         */
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel value to " + name.toLowerCase());
            putValue("value", c);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("value");
            buttonPanel.setBackground(c);
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
•static Keystroke getKeyStroke (String description)
        Конструирует объект типа KeyStroke из удобочитаемого описания (последовательности символьных строк, разделяемых
        пробелами!. Описание начинается с нулевого или большего количества модификаторов shift control Ctrl meta alt altGraf и
        оканчивается строкой со словом typed и последующим символом (например, "typed а") или необязательным спецификатором
        события (по умолчанию — pressed или released) и последующим кодом клавиш и. Код клавиши, снабженный префиксом VK_,
        должен соответствовать константе KeyEvent; например, код клавиши <INSERT> соответствует константе KeyEvent.VK_INSERT.
----------------------------------------------------------------------------------------------------------------------
*/