package book.chap12;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 0;
    int y = 0;

    public static void main (String[] args) {
        SimpleAnimation gui = new SimpleAnimation ();
        gui.go();
    } //end main

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(500+18, 500+42);
        frame.setVisible(true);

        for (int i = 0; i < 450; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(20);
            } catch(Exception ex) { }
        } //end for i (0-130)

    } //end go() method

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x,y,50,50);

        } //end paintComponent(Graphics g) method
    } //end inner class MyDrawPanel
} // end outer class SimpleAnimation




