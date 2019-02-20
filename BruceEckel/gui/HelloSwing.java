//: gui/HelloSwing.java
package gui;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        int frameSizeWidth = 300;
        int frameSizeHeight = 100;
//        int frameLocateX = (screenSize.width - frameSizeWidth)/2;
//        int frameLocateY = (screenSize.height - frameSizeHeight)/2;
        int frameLocateX = (screenWidth - frameSizeWidth)/2;
        int frameLocateY = (screenHeight - frameSizeHeight)/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSizeWidth, frameSizeHeight);
        frame.setLocation(frameLocateX,frameLocateY);
        frame.setVisible(true);
    }
} ///:~