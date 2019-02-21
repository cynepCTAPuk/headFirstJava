//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise7 extends JFrame {
    String[] strings = "ABCDEF".split("");
    private JButton jButton = new JButton("jButton");
    private JCheckBox jCheckBox = new JCheckBox("jCheckBox");
    private JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("jCheckBoxMenuItem");
    private JComboBox<String> jComboBox = new JComboBox<>(strings);
    private JFileChooser jFileChooser = new JFileChooser();
    private JMenu jMenu = new JMenu("jMenu");
    private JMenuItem jMenuItem = new JMenuItem("jMenuItem");
    private JRadioButton jRadioButton = new JRadioButton("jRadioButton");
    private JRadioButtonMenuItem jRadioButtonMenuItem =
            new JRadioButtonMenuItem("jRadioButtonMenuItem");
    private JTextField jTextField = new JTextField("jTextField", 55);
    private JToggleButton jToggleButton = new JToggleButton("jToggleButton");

    private JTextArea jTextArea = new JTextArea("jTextArea",20,15);

    Exercise7() {
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jButton.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jCheckBox.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jCheckBoxMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jCheckBoxMenuItem.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jComboBox.getClass().getSimpleName();
                int i = jComboBox.getSelectedIndex();
                jTextField.setText(s + " " + i);
            }
        });
        jFileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jFileChooser.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jMenu.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jMenuItem.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jRadioButton.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jRadioButtonMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jRadioButtonMenuItem.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });
        jToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = jToggleButton.getClass().getSimpleName();
                jTextField.setText(s);
            }
        });

        jTextField.setFont(new Font("monospaced", Font.PLAIN, 12));

        setLayout(new FlowLayout());

        add(jTextField);
        add(jButton);
        add(jCheckBox);
        add(jCheckBoxMenuItem);
        add(jComboBox);
        add(jFileChooser);
        add(jMenu);
        add(jMenuItem);
        add(jRadioButton);
        add(jRadioButtonMenuItem);
        add(jToggleButton);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise7(), 500, 500);
    }
}