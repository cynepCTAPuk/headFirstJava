package chap10_GUI.sizedFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Cay Horstmann
 * @version 1.35 2018-04-10
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.pack(); // possible minimum for locate inner components
//            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximum size
            frame.setVisible(true);
            frame.toFront();
//            frame.toBack();
        });
    }
}

class SizedFrame extends JFrame {
    public SizedFrame() {
        // get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location
        setSize(screenWidth / 4, screenHeight / 4);
        setLocationByPlatform(true);

        // set frame icon
        Image img = new ImageIcon("src/chap10_GUI/red-ball.gif").getImage();
        setIconImage(img);
    }
}
