package chap10_GUI.notHelloWorld;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

/**
 * @author Cay Horstmann
 * @version 1.34 2018-04-10
 */
public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that contains a message panel.
 */
class NotHelloWorldFrame extends JFrame {
    NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        pack();
    }
}

/**
 * A component that displays a message.
 */
class NotHelloWorldComponent extends JComponent {
    private static final int MESSAGE_X = 75;
    private static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
