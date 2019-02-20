//: gui/TextArea.java
// Using the JTextArea control.
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import util.*;
import static util.SwingConsole.*;
public class TextArea extends JFrame {
    private JButton
            addData = new JButton("Add Data"),
            clearData = new JButton("Clear Data");
    private JTextArea textArea = new JTextArea(20, 40);
    private Map<String,String> map = new TreeMap<>();
    public TextArea() {
        map.putAll(Countries.capitals()); // Use up all the data:

        addData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry me : map.entrySet())
                    textArea.append(String.format("%-25s: %s\n",me.getKey(), me.getValue()));
            }
        });
        clearData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { textArea.setText("");}
        });

        textArea.setFont(new Font("monospaced",Font.PLAIN, 12));
        textArea.setColumns(70);
        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(addData);
        add(clearData);
    }
    public static void main(String[] args) {
        run(new TextArea(), 515, 425);
    }
} ///:~