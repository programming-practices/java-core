package slider;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.15 2015-06-12
 */
public class SliderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SliderFrame frame = new SliderFrame();
            frame.setTitle("SliderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}