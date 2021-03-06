//: chap22_gui/TextPane.java
// The JTextPane control is a little editor.
package chap22_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import util.*;
import static util.SwingConsole.*;
public class TextPane extends JFrame {
    private JButton b = new JButton("Add Text");
    private JTextPane tp = new JTextPane();
    private static Generator sg = new RandomGenerator.String(7);
    public TextPane() {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 3; i++) {
                    tp.setText(tp.getText() + sg.next() + "\n");
                }
            }
        });
        add(new JScrollPane(tp));
        add(BorderLayout.SOUTH, b);
    }
    public static void main(String[] args) {
        run(new TextPane(), 475, 425);
    }
} ///:~