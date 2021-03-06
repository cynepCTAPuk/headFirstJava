//: chap22_gui/Button2.java
// Responding to button presses.
package chap22_gui;
import util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button2 extends JFrame {
    private JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");
    private JTextField txt = new JTextField(10);

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        }
    }

    private ButtonListener b = new ButtonListener();

    public Button2() {
        b1.addActionListener(b);
        b2.addActionListener(b);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(), 200, 150);
    }
} ///:~