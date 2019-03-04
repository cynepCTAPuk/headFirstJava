//: chap22_gui/Menus.java
// Submenus, check box menu items, swapping menus, mnemonics (shortcuts) and action commands.
package chap22_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;

public class Menus extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};
    private JTextField textField = new JTextField("No flavor", 30);
    private JMenuBar menuBar1 = new JMenuBar();
    private JMenu
            menuFile = new JMenu("File"),
            menuFlav = new JMenu("Flavors"),
            menuSafe = new JMenu("Safety");
    // Alternative approach:
    private JCheckBoxMenuItem[] safety = {
            new JCheckBoxMenuItem("Guard"),
            new JCheckBoxMenuItem("Hide")};
    private JMenuItem[] file = {new JMenuItem("Open")};

    // A second menu bar to swap to:
    private JMenuBar menuBar2 = new JMenuBar();
    private JMenu fooBar = new JMenu("fooBar");
    private JMenuItem[] other = {
            // Adding a menu shortcut (mnemonic) is very simple,
            // but only JMenuItems can have them in their constructors:
            new JMenuItem("Foo", KeyEvent.VK_F),
            new JMenuItem("Bar", KeyEvent.VK_A),
            // No shortcut:
            new JMenuItem("Baz"),
    };
    private JButton button_swap_menus = new JButton("Swap Menus");

    class BL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuBar m = getJMenuBar();
            setJMenuBar(m == menuBar1 ? menuBar2 : menuBar1);
            validate(); // Refresh the frame
        }
    }
    class ML implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem) e.getSource();
            String actionCommand = target.getActionCommand();
            if (actionCommand.equals("Open")) {
                String s = textField.getText();
                boolean chosen = false;
                for (String flavor : flavors)
                    if (s.equals(flavor))
                        chosen = true;
                if (!chosen)
                    textField.setText("Choose a flavor first!");
                else
                    textField.setText("Opening " + s + ". Mmm, mm!");
            }
        }
    }
    class FL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem) e.getSource();
            textField.setText(target.getText());}}
    // Alternatively, you can create a different class for each different MenuItem.
    // Then you don’textField have to figure out which one it is:
    class FooL implements ActionListener {
        public void actionPerformed(ActionEvent e) { textField.setText("Foo selected");}}
    class BarL implements ActionListener {
        public void actionPerformed(ActionEvent e) { textField.setText("Bar selected");}}
    class BazL implements ActionListener {
        public void actionPerformed(ActionEvent e) { textField.setText("Baz selected");}}
    class CMIL implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            JCheckBoxMenuItem target = (JCheckBoxMenuItem) e.getSource();
            String actionCommand = target.getActionCommand();
            if (actionCommand.equals("Guard"))
                textField.setText("Guard the Ice Cream! " + "Guarding is " + target.getState());
            else if (actionCommand.equals("Hide"))
                textField.setText("Hide the Ice Cream! " + "Is it hidden? " + target.getState());
        }
    }

    public Menus() {
        ML ml = new ML();
        CMIL cmil = new CMIL();
        safety[0].setActionCommand("Guard");
        safety[0].setMnemonic(KeyEvent.VK_G);
        safety[0].addItemListener(cmil);
        safety[1].setActionCommand("Hide");
        safety[1].setMnemonic(KeyEvent.VK_H);
        safety[1].addItemListener(cmil);
        other[0].addActionListener(new FooL());
        other[1].addActionListener(new BarL());
        other[2].addActionListener(new BazL());
        FL fl = new FL();
        int n = 0;
        for (String flavor : flavors) {
            JMenuItem mi = new JMenuItem(flavor);
            mi.addActionListener(fl);
            menuFlav.add(mi);
            if ((n++ + 1) % 3 == 0) menuFlav.addSeparator(); // Add separators at intervals:
        }
        for (JCheckBoxMenuItem sfty : safety)
            menuSafe.add(sfty);
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuSafe.setMnemonic(KeyEvent.VK_A);
        menuFile.add(menuSafe);
        for (int i = 0; i < file.length; i++) {
            file[i].addActionListener(ml);
            menuFile.add(file[i]);
        }
        menuBar1.add(menuFile);
        menuBar1.add(menuFlav);
        setJMenuBar(menuBar1);
        textField.setEditable(false);
        add(textField, BorderLayout.CENTER);

        // Set up the system for swapping menus:
        button_swap_menus.addActionListener(new BL());
        button_swap_menus.setMnemonic(KeyEvent.VK_S);
        add(button_swap_menus, BorderLayout.NORTH);
        for (JMenuItem oth : other)
            fooBar.add(oth);
        fooBar.setMnemonic(KeyEvent.VK_B);
        menuBar2.add(fooBar);
    }

    public static void main(String[] args) {
        run(new Menus(), 300, 200);
    }
} ///:~