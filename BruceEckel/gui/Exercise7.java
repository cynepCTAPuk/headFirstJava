//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class Exercise7 extends JFrame {
    private JTextArea inputTextArea = new JTextArea(10, 55);
    private JTextArea outputTextArea = new JTextArea(10, 55);
    private JTextField regExpTextField = new JTextField(10);
    private JButton
            searchButton = new JButton("Search"),
            clearInputButton = new JButton("Clear Input");

    Exercise7() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exp = inputTextArea.getText();
                String reg = regExpTextField.getText();
            }
        });
        clearInputButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText("");
                outputTextArea.setText("");
                regExpTextField.setText("");
            }
        });

        inputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        outputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

        setLayout(new FlowLayout());
        add(new JScrollPane(inputTextArea));
        add(new JScrollPane(outputTextArea));
        add(regExpTextField);
        add(searchButton);
        add(clearInputButton);

    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise7(), 410, 500);
    }
}