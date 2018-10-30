package book.chap12;

import javax.swing.*;
import java.awt.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JButton button = new JButton("click me");
        button.setBackground(Color.ORANGE);
//        button.setText("I've been clicked!");
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}
