//: chap22_gui/Button1.java
// Putting buttons on a Swing application.
package chap22_gui;
import util.*;

import javax.swing.*;
import java.awt.*;

public class Button1 extends JFrame {
    private JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");
    public Button1() {
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(new JButton("Button 3"));
    }
    public static void main(String[] args) {
        SwingConsole.run(new Button1(), 200, 100);
    }
} ///:~