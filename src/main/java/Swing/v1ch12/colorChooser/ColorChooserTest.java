package colorChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.04 2015-06-12
 */
public class ColorChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ColorChooserFrame();
            frame.setTitle("ColorChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
