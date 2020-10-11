package comboBox;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.35 2015-06-12
 */
public class ComboBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ComboBoxFrame();
            frame.setTitle("ComboBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}