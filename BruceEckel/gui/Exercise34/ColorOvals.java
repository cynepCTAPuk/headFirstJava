//: gui/ColorOvals.java
// A visual demonstration of threading.
package gui.Exercise34;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.*;

import static util.SwingConsole.*;

class COval extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    public void paintComponent(Graphics g) {
        g.setColor(color);
        Dimension s = getSize();
        int radius = (s.width + s.height)/4;
        int midX = s.width/2;
        int midY = s.height/2;
        int[] X = new int[5];
        int[] Y = new int[5];
        for (int i = 0; i < 5; i++) {
            double x = Math.cos(2*Math.PI * i / 5);
            double y = Math.sin(2*Math.PI * i / 5);
            X[i] = (int)x * radius + midX;
            Y[i] = (int)y * radius + midY;
        }
        g.fillPolygon(X, Y, 5);
    }


    public COval(int pause) { this.pause = pause;}
    public void run() {
        try {
            while (!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint(); // Asynchronously request a paint()
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
    }
}

public class ColorOvals extends JFrame {
    private int grid = 3;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public void setUp() {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            COval cb = new COval(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        ColorOvals boxes = new ColorOvals();
        if (args.length > 0) boxes.grid = Integer.valueOf(args[0]);
        if (args.length > 1) boxes.pause = Integer.valueOf(args[1]);
        boxes.setUp();
        run(boxes, 500, 500);
    }
} ///:~