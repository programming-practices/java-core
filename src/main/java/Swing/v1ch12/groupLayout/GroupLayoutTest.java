package groupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.01 2015-06-12
 */
public class GroupLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("GroupLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}