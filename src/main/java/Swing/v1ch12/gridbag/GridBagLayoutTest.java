package gridbag;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.35 2015-06-12
 */
public class GridBagLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("GridBagLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}