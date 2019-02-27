//: gui/Color5Stars.java
// A visual demonstration of threading.
package gui.Exercise34;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.*;

import static util.SwingConsole.*;

class Star extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    public void paintComponent(Graphics g) {
        g.setColor(color);
        Dimension s = getSize();
        int n = 10;
        double m = 40.0 / 105;
        double midX = s.width >> 1;
        double midY = s.height >> 1;
        double outerR = (midX < midY) ? midX : midY;
        double innerR = outerR * m;
        double r = innerR;
        int[] X = new int[n];
        int[] Y = new int[n];
        double pi = Math.PI * 2;
        for (int i = 0; i < n; i++) {
            double angle = pi * i / n - pi / 4;
            double x = Math.cos(angle);
            double y = Math.sin(angle);
            r = (r == outerR) ? innerR : outerR;
            X[i] = (int) (x * r + outerR);
            Y[i] = (int) (y * r + outerR);
        }
        g.fillPolygon(X, Y, n);
    }

    public Star(int pause) {
        this.pause = pause;
    }

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

public class Color5Stars extends JFrame {
    private int grid = 10;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public void setUp() {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            Star cb = new Star(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        Color5Stars boxes = new Color5Stars();
        if (args.length > 0) boxes.grid = Integer.valueOf(args[0]);
        if (args.length > 1) boxes.pause = Integer.valueOf(args[1]);
        boxes.setUp();
        run(boxes, 500, 500);
    }
} ///:~