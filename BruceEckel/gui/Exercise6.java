//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
public class Exercise6 extends JFrame {
    private JTextArea inputTextArea = new JTextArea(10, 55);
    private JTextArea outputTextArea = new JTextArea(10, 55);
    private JTextField regExpTextField = new JTextField(10);
    private JButton
            searchButton = new JButton("Search"),
            clearInputButton = new JButton("Clear Input");

    Exercise6() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exp = inputTextArea.getText();
                String reg = regExpTextField.getText();
                outputTextArea.setText(RegExp(exp,reg));
            }
        });
        clearInputButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { inputTextArea.setText("");}
        });

        inputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        outputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

        setLayout(new FlowLayout());
        add(new JScrollPane(inputTextArea));
        add(regExpTextField);
        add(new JScrollPane(outputTextArea));
        add(searchButton);
        add(clearInputButton);

    }

    String RegExp(String exp, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(exp);
        String string = "";
        while (m.find()) {
            string += "Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1 + "\n");
        }
        if(string == "") return "\"*******\"";
        return string;
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise6(), 410, 500);
    }
} /* Output:
Input: "abcabcabcdefabc"
Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14
Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14
Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14
Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
*///:~