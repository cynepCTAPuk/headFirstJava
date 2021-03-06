//: chap22_gui/HelloLabel.java
package chap22_gui;
import javax.swing.*;
import java.util.concurrent.*;
public class HelloLabel {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocation(500,400);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(3);
        label.setText("Hey! This is Different!");
    }
} ///:~