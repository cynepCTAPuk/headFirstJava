//: gui/Color5Stars.java
// A visual demonstration of threading.
package gui.Exercise34;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.*;

import static util.SwingConsole.*;

class CStar extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);
    public void paintComponent(Graphics g) {
        g.setColor(color);
        Dimension s = getSize();
        int gapX = s.width - s.width/8;
        int gapY = s.height - s.height/8;
        g.drawLine(gapX, gapY, s.width-gapX, s.height-gapY);
        g.drawLine(s.width/2, gapY, s.width/2, s.height-gapY);
        g.drawLine(gapX,s.height-gapY, s.width-gapX, gapY);
        g.drawLine(gapX,s.height/2, s.width-gapX, s.height/2);
    }
    public CStar(int pause) { this.pause = pause; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint(); // Asynchronously request a paint()
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch(InterruptedException e) {
            // Acceptable way to exit
        }
    }
}

public class ColorStars extends JFrame {
    private int grid = 10;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();
    public void setUp() {
        setLayout(new GridLayout(grid, grid));
        for(int i = 0; i < grid * grid; i++) {
            CStar cb = new CStar(pause);
            add(cb);
            exec.execute(cb);
        }
    }
    public static void main(String[] args) {
        ColorStars boxes = new ColorStars();
        if(args.length > 0) boxes.grid = Integer.valueOf(args[0]);
        if(args.length > 1) boxes.pause = Integer.valueOf(args[1]);
        boxes.setUp();
        run(boxes, 500, 500);
    }
} ///:~