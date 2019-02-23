//: gui/SimpleMenus.java
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;
public class SimpleMenus extends JFrame {
    private JTextField textField =
            new JTextField(15);
    private JMenu[] menus = {
            new JMenu("Winken"), new JMenu("Blinken"), new JMenu("Nod")};
    private JMenuItem[] menuItems = {
            new JMenuItem("Fee"), new JMenuItem("Fi"), new JMenuItem("Fo"),
            new JMenuItem("Zip"), new JMenuItem("Zap"), new JMenuItem("Zot"),
            new JMenuItem("Olly"), new JMenuItem("Oxen"), new JMenuItem("Free")};
    private ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            textField.setText(((JMenuItem)e.getSource()).getText());}};
    public SimpleMenus() {
        for(int i = 0; i < menuItems.length; i++) {
            menuItems[i].addActionListener(al);
            menus[i % 3].add(menuItems[i]);
        }
        JMenuBar menuBar = new JMenuBar();
        for(JMenu menu : menus)
            menuBar.add(menu);
        setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        add(textField);
    }
    public static void main(String[] args) {
        run(new SimpleMenus(), 200, 150);
    }
} ///:~