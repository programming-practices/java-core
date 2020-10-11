package fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.25 2015-06-12
 */
public class FileChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("FileChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
