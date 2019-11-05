package unsort;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
    JButton button1;
    JButton button2;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public  void go() {
        JFrame frame = new JFrame();
        button1 = new JButton("click me");
        button2 = new JButton("Button");
        button1.setSize(100,100);
        button2.setSize(10,10);

        button1.addActionListener(this);
        // frame.getContentPane().add(button1);
        frame.add(button1);
        frame.add(button2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        button1.setText("I've been clicked!");
    }

}
