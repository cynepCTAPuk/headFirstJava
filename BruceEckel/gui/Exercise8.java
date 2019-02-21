//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise8 extends JFrame {
    private JTextArea jTextArea = new JTextArea(10, 55);
    private JTextField jTextField = new JTextField(10);
    private JButton jButton = new JButton("Search");
    private Component component = new Component() {
        public void setCursor(Cursor cursor) {
            super.setCursor(cursor);
        }
    };

    Exercise8() {
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exp = jTextArea.getText();
                String reg = jTextField.getText();
            }
        });

        jTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

        setLayout(new FlowLayout());
        add(new JScrollPane(jTextArea));
        add(jTextField);
        add(jButton);
    }


    public static void main(String[] args) {
        SwingConsole.run(new Exercise8(), 410, 500);
    }
}