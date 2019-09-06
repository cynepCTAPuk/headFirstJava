package chap10_GUI.simpleFrame;

import java.awt.*;
import javax.swing.JFrame;

/**
 * @author Cay Horstmann
 * @version 1.34 2018-04-10
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame1 = new SimpleFrame();
            var frame2 = new SimpleFrame();
            var frame3 = new SimpleFrame();
            var frame4 = new SimpleFrame();
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame1.setUndecorated(true); // default false
//            frame1.setLocation(0, 0); // default 0,0
//            frame1.setBounds(0,0,300,200);
//            frame1.setResizable(false); // default true
/*
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            frame1.setSize(screenWidth / 2, screenHeight / 2);
            frame1.setTitle("1"); // default empty
*/
            frame1.setVisible(true);
/*
            frame2.setSize(screenWidth / 2, screenHeight / 2);
            frame2.setLocation(screenWidth / 2, 0);
            frame2.setTitle("2"); // default empty
            frame2.setVisible(true);
            frame3.setSize(screenWidth / 2, screenHeight / 2);
            frame3.setLocation(0, screenHeight/2);
            frame3.setTitle("3"); // default empty
            frame3.setVisible(true);
            frame4.setSize(screenWidth / 2, screenHeight / 2);
            frame4.setLocation(screenWidth / 2, screenHeight/2);
            frame4.setTitle("4"); // default empty
            frame4.setVisible(true);
*/
        });
    }
}

class SimpleFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
//        setLocation(800,400);
        setTitle("Simple Frame");
    }
}
