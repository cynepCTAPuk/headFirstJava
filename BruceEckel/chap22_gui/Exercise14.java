//: chap22_gui/TextPane.java
// The JTextPane control is a little editor.
package chap22_gui;
import util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;

public class Exercise14 extends JFrame {
    private JButton b = new JButton("Add Text");
    private JTextArea ta = new JTextArea();
    private static Generator sg = new RandomGenerator.String(7);
    public Exercise14() {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 3; i++) {
//                    ta.setText(ta.getText() + sg.next() + "\n");
                    ta.append(sg.next() + "\n");
                }
            }
        });
        add(new JScrollPane(ta));
        add(BorderLayout.SOUTH, b);
    }
    public static void main(String[] args) {
        run(new Exercise14(), 475, 425);
    }
} ///:~