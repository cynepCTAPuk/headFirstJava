//: chap22_gui/HelloSwing.java
package chap22_gui;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        int frameSizeWidth = 300;
        int frameSizeHeight = 100;
        int frameLocateX = (screenWidth - frameSizeWidth)/2;
        int frameLocateY = (screenHeight - frameSizeHeight)/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSizeWidth, frameSizeHeight);
        frame.setLocation(frameLocateX,frameLocateY);
        frame.setVisible(true);
    }
} ///:~