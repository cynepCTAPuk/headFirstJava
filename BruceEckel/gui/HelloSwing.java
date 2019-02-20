//: gui/HelloSwing.java
package gui;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenSizeWidth = (int)screenSize.getWidth();
        int screenSizeHeight = (int)screenSize.getHeight();
        int frameSiseWidth = 300;
        int frameSiseHeight = 100;
        int frameLocateX = (screenSizeWidth - frameSiseWidth)/2;
        int frameLocateY = (screenSizeHeight - frameSiseHeight)/2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSiseWidth, frameSiseHeight);
        frame.setLocation(frameLocateX,frameLocateY);
        frame.setVisible(true);
    }
} ///:~