package Swing.v1ch12.eventTracer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.14 2015-08-20
 */
public class EventTracerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new EventTracerFrame();
            frame.setTitle("EventTracerTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class EventTracerFrame extends JFrame {
    public EventTracerFrame() {
        // add a slider and a button
        add(new JSlider(), BorderLayout.NORTH);
        add(new JButton("tem.Test"), BorderLayout.SOUTH);

        // trap all events of components inside the frame
        EventTracer tracer = new EventTracer();
        tracer.add(this);
        pack();
    }
}
