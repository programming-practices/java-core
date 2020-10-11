package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
