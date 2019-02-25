//: gui/HTMLButton.java
// Putting HTML text on Swing components.
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;
public class HTMLButton extends JFrame {
    private JButton button = new JButton(
            "<html><button><font size=+2>" + "<center>Hello!<br><i>Press me now!");
    public HTMLButton() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(new JLabel("<html>" + "<i><font size=+4>Kapow!"));
                // Force a re-layout to include the new label:
                validate();
            }
        });
        setLayout(new FlowLayout());
        add(button);
    }
    public static void main(String[] args) {
        run(new HTMLButton(), 200, 500);
    }
} ///:~