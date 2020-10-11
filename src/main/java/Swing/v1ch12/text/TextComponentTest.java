package text;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.41 2015-06-12
 */
public class TextComponentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new TextComponentFrame();
            frame.setTitle("TextComponentTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
