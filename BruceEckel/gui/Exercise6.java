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
    private JButton
            addData = new JButton("Reg Data"),
            clearData = new JButton("Clear Data");
    private JTextArea textExp = new JTextArea(10, 55);
    private JTextArea textResult = new JTextArea(10, 55);
    private JTextField textReg = new JTextField(10);

    Exercise6() {
        addData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exp = textExp.getText();
                String reg = textReg.getText();
                textResult.setText(RegExp(exp,reg));
            }
        });
        clearData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textExp.setText("");
            }
        });

        textExp.setFont(new Font("monospaced", Font.PLAIN, 12));
        textResult.setFont(new Font("monospaced", Font.PLAIN, 12));
//        textExp.setColumns(70);
//        textResult.setColumns(70);

        setLayout(new FlowLayout());
        add(new JScrollPane(textExp));
        add(textReg);
        add(new JScrollPane(textResult));
        add(addData);
        add(clearData);

    }

    String RegExp(String exp, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(exp);
        String string = "";
        while (m.find()) {
            string += "Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1 + "\n");
        }
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