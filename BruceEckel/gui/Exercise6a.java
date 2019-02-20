//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
package gui;
import util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class Exercise6a extends JFrame {
    private JTextArea
            inputArea = new JTextArea(20, 20),
            outputArea = new JTextArea(20, 20);
    private JTextField txt = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JButton clearButton = new JButton("Clear");

    public Exercise6a() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputArea.getText();
                String regexToMatch = txt.getText();
                for (String regex : regexToMatch.split(" ")) {
                    outputArea.append("Regular expression: \"" + regex + "\"");
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(inputText);
                    while (m.find()) {
                        outputArea.append("\nMatch \"" + m.group() + "\" at positions " +
                                m.start() + "-" + (m.end() - 1) + "\n");
                    }
                    outputArea.append("\n*********************\n");
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputArea.setText("");
                outputArea.setText("");
                txt.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(inputArea));
        add(new JScrollPane(outputArea));
        add(txt);
        add(searchButton);
        add(clearButton);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise6a(), 475, 425);
    }
}