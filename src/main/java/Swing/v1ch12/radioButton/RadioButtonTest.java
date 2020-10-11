package radioButton;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class RadioButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new RadioButtonFrame();
            frame.setTitle("RadioButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}