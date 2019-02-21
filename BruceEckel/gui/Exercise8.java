package gui;

import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise8 extends JFrame {
    private JTextArea jTextArea = new JTextArea("jTextArea", 10, 55);
    private JTextField jTextField = new JTextField("jTextField", 10);
    private JButton jButton = new JButton("jButton");
    private Cursor cursor = new Cursor(0);

    Exercise8() {
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText(cursor.toString());
                jTextField.setText(cursor.getName());
            }
        });
        jTextArea.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
                final int x = e.getX();
                final int y = e.getY();
                // only display a hand if the cursor is over the items
                jTextArea.setCursor(new Cursor(12));
            }

            public void mouseDragged(MouseEvent e) {}
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