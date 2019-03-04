package chap22_gui;
//: chap22_gui/SubmitLabelManipulationTask.java
import javax.swing.*;
import java.util.concurrent.*;
public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocation(500,400);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(3);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                label.setText("Hey! This is Different!");
            }
        });
    }
} ///:~