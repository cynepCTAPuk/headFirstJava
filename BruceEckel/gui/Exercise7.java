//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise7 extends JFrame {
    private JButton jButton = new JButton("Clear Input");
    private JCheckBox jCheckBox = new JCheckBox();
    private JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem();
    private JMenu jMenu = new JMenu();
    private JMenuItem jMenuItem = new JMenuItem();
    private JPopupMenu jPopupMenu = new JPopupMenu();
    private JRadioButton jRadioButton = new JRadioButton();
    private JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem();
    private JToggleButton jToggleButton = new JToggleButton();
    private JToolBar jToolBar = new JToolBar();

    private JTextArea jTextArea = new JTextArea(10, 55);
    private JTextField jTextField = new JTextField(10);


    Exercise7() {
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jButton.getClass().getSimpleName();
                jTextArea.setText(s);
            }
        });
        jCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jCheckBox.getClass().getSimpleName();
                jTextArea.setText(s);
            }
        });

        jTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

        setLayout(new FlowLayout());
        add(new JScrollPane(jTextArea));
        add(jTextField);
        add(jButton);
        add(jCheckBox);

    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise7(), 410, 500);
    }
}