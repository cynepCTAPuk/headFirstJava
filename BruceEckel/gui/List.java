//: gui/List.java
package gui;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;
public class List extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };
    private DefaultListModel lItems = new DefaultListModel();
    private JList list = new JList(lItems);
    private JTextArea textArea = new JTextArea(flavors.length, 20);
    private JButton button = new JButton("Add Item");
    private int count = 0;
    private ActionListener bl = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(count < flavors.length) {
                lItems.add(0, flavors[count++]);
            } else {
                // Disable, since there are no more flavors left to be added to the List
                button.setEnabled(false);
            }
        }
    };
    private final ListSelectionListener ll = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) return;
            textArea.setText("");
            for (Object item : list.getSelectedValues())
                textArea.append(item + "\n");
        }
    };
    public List() {
        textArea.setEditable(false);
        setLayout(new FlowLayout());
        // Create Borders for components:
        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
        list.setBorder(brd);
        textArea.setBorder(brd);
        // Add the first four items to the List
        for(int i = 0; i < 4; i++)
            lItems.addElement(flavors[count++]);
        add(textArea);
        add(list);
        add(button);
        // Register event listeners
        list.addListSelectionListener(ll);
        button.addActionListener(bl);
    }
    public static void main(String[] args) {
        run(new List(), 250, 375);
    }
} ///:~