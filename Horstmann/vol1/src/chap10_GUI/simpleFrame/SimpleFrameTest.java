package chap10_GUI.simpleFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * @author Cay Horstmann
 * @version 1.34 2018-04-10
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
