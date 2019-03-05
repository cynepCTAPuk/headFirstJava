//: chap22_gui/GridLayout1.java
// Demonstrates GridLayout.
package chap22_gui;
import javax.swing.*;
import java.awt.*;
import static util.SwingConsole.*;
public class GridLayout1 extends JFrame {
    public GridLayout1() {
        setLayout(new GridLayout(7,3));
        for(int i = 0; i < 20; i++)
            add(new JButton("Button " + i));
    }
    public static void main(String[] args) {
        run(new GridLayout1(), 300, 300);
    }
} ///:~