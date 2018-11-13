package chap12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame frame;
    JLabel labelWest;
    JLabel labelNorth;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    } // end main

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());
        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        labelWest = new JLabel("I'm labelWest");
        labelNorth = new JLabel("I'm labelNorth");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, labelWest);
        frame.getContentPane().add(BorderLayout.NORTH, labelNorth);

        frame.setLocation(700, 200);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            labelWest.setText("Ouch!");
        } // end actionPerformed method
    } // end inner class

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        } // end actionPerformed method
    } //end inner class
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
/*
        int file = 100 + (int) (Math.random() * (433 - 100) + 1); // Images in frame
        String path = "C:\\java\\headFirstJava\\pics\\i_" + file + ".jpg";
        Image image = new ImageIcon(path).getImage();
        BufferedImage readImage = null;
        int h = 0;
        int w = 0;
        try {
            readImage = ImageIO.read(new File(path));
            w = readImage.getWidth();
            h = readImage.getHeight();
        } catch (Exception e) {
            readImage = null;
        }
        g.drawImage(image, (this.getWidth() / 2 - w / 2), (this.getHeight() / 2 - h / 2), this);
        // g.drawImage(image, 0, 0, this);
*/
/*
        Graphics2D g2d = (Graphics2D) g; //Gradient
        GradientPaint gradient = new GradientPaint(this.getWidth()/4, this.getHeight()/4, Color.blue, (3*this.getWidth())/4, (3*this.getHeight())/4, Color.orange);
        g2d.setPaint(gradient);
        int sizeX = 200;
        int sizeY = 200;
        g2d.fillOval((this.getWidth()/2 - sizeX/2), (this.getHeight()/2 - sizeY/2), sizeX, sizeY);
*/
            g.fillRect(0, 0, this.getWidth(), this.getHeight()); //Change oval color randomly
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color color = new Color(red, green, blue);
            g.setColor(color);
            int sizeX = 200;
            int sizeY = 200;
            g.fillOval((this.getWidth() / 2 - sizeX / 2), (this.getHeight() / 2 - sizeY / 2), sizeX, sizeY);
        }
    }
} // end outer class