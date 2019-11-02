package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    } //end main

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 200);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.setSize(500+15, 500+65);

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
    } //end go()

    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    } //end actionPerformed
} //end class SimpleGui3C (main)

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
/*
        int file = 100 + (int) (Math.random()*(433-100)+1);
        String path = "C:\\java\\HeadFirstJava\\pics\\i_"+file+".jpg";
        Image image = new ImageIcon(path).getImage();
        BufferedImage readImage = null;
        try {
            readImage = ImageIO.read(new File(path));
            int h = readImage.getHeight();
            int w = readImage.getWidth();
        } catch (Exception e) {
            readImage = null;
        } //end try-catch
        // g.drawImage(image, 0, 0, this);
        g.drawImage(image, (this.getWidth()/2 - h/2), (this.getHeight()/2 - w/2), this);
*/
/*
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(this.getWidth()/4, this.getHeight()/4, Color.blue, (3*this.getWidth())/4, (3*this.getHeight())/4, Color.orange);
        g2d.setPaint(gradient);
        int sizeX = 200;
        int sizeY = 200;
        g2d.fillOval((this.getWidth()/2 - sizeX/2), (this.getHeight()/2 - sizeY/2), sizeX, sizeY);
*/

        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color color = new Color(red, green, blue);
        g.setColor(color);
        int sizeX = 200;
        int sizeY = 200;
        g.fillOval((this.getWidth()/2 - sizeX/2), (this.getHeight()/2 - sizeY/2), sizeX, sizeY);

    } //end paintComponent(Graphics g)
} //end class MyDrawPanel