//: gui/HelloSwing.java
package gui;
import javax.swing.*;
public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocation(500,400);
        frame.setVisible(true);
    }
} ///:~