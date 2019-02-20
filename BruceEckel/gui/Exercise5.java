//: gui/Button2b.java
// Using anonymous inner classes.
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;

public class Exercise5 extends JFrame {
    private JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2"),
            b3 = new JButton("Button 3");
    private JTextField txt = new JTextField(10);
    private ActionListener b = e -> {
        String name = ((JButton)e.getSource()).getText();
        txt.setText(name);
    };
    public Exercise5() {
        b1.addActionListener(b);
        b2.addActionListener(b);
        b3.addActionListener(b);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }
    public static void main(String[] args) {
        run(new Exercise5(), 300, 100);
    }
} ///:~