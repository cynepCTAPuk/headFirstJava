//: net/mindview/util/SwingConsole.java
// Tool for running Swing demos from the
// console, both applets and JFrames.
package util;
import javax.swing.*;
import java.awt.*;

public class SwingConsole {
    public static void run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                GraphicsDevice gd;
//                gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//                int screenWidth = gd.getDisplayMode().getWidth();
//                int screenHeight = gd.getDisplayMode().getHeight();
//                f.setLocation((screenWidth - width)/3,(screenHeight - height)/3);

                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        run(new JFrame(), 400,400);
    }
} ///:~