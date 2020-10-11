package multithreading.Others.CayHorstmann.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Shows an animated bouncing ball.
 *
 * @author Cay Horstmann
 * @version 1.34 2015-06-21
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame {
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
    private BallComponent ballComponent;

    /**
     * Constructs the frame with the component for showing the bouncing ball and
     * Start and Close buttons
     */
    public BounceFrame() {
        setTitle("Bounce");
        ballComponent = new BallComponent();
        add(ballComponent, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container.
     *
     * @param c        the container
     * @param title    the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the panel and makes it bounce 1,000 times.
     */
    public void addBall() {
        try {
            Ball ball = new Ball();
            ballComponent.add(ball);

            for (int i = 1; i <= STEPS; i++) {
                ball.move(ballComponent.getBounds());
                ballComponent.paint(ballComponent.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
        }
    }
}
