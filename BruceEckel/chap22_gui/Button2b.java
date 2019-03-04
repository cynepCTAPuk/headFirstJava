//: chap22_gui/Button2b.java
// Using anonymous inner classes.
package chap22_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;
public class Button2b extends JFrame {
    private JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");
    private JTextField txt = new JTextField(10);
    private ActionListener b = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };
    public Button2b() {
        b1.addActionListener(b);
        b2.addActionListener(b);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }
    public static void main(String[] args) {
        run(new Button2b(), 200, 100);
    }
} ///:~