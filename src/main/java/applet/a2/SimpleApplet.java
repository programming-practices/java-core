package applet.a2;

import javax.swing.*;

public class SimpleApplet extends JApplet {
    @Override
    public void init() {
        add(new JButton("submit"));
    }
}
