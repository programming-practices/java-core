package circleLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.33 2015-06-12
 */
public class CircleLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CircleLayoutFrame();
            frame.setTitle("CircleLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}