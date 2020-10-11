package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class ExampleJButton {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a button panel
 */
class ButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel buttonPanel;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);

        // create buttons
        JButton yellowButton = new JButton("Yellow");
        yellowButton.setLocation(5, 20);
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        JButton exitButton = new JButton("EXIT");

        buttonPanel = new JPanel();

        // add buttons to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(exitButton);

        // add panel to frame
        add(buttonPanel);

        /*Затем для каждого цвета создается один объект. Все эти объекты устанавливаются в качестве приемников событий от
        соответствующих кнопок:*/
        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
        exitButton.addActionListener(e ->
        {
            System.exit(0);
        });
    }

    /*Допустим, что после щелчка на кнопке требуется изменить цвет фона панели. Новый цвет указывается в классе приемника
    событий следующим образом:*/

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
-----------------------------------------------------------------------------------------------------------------------
•JButton (String label)
•JButton(Icon icon)
•JButton (String label, Icon icon)
    Создают кнопку. Символьная строка, передаваемая в качестве параметра, может содержать текст, аначиная с версии Java
    SE1.3, — HTML-разметку, например<html xb>ok</b x /html>.
-----------------------------------------------------------------------------------------------------------------------
*/