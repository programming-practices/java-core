package checkBox;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class CheckBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CheckBoxFrame();
            frame.setTitle("CheckBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
