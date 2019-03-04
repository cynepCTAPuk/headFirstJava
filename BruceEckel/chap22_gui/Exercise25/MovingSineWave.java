//: chap22_gui/MovingSineWave.java
// Drawing with Swing, using a JSlider.
package chap22_gui.Exercise25;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.concurrent.*;

import static util.SwingConsole.*;

class SineDraw extends JPanel {
    private static final int SCALEFACTOR = 1_000;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;
    private int step = 0;
    public SineDraw() { setCycles(1);}
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++)
            pts[i] = (int) (maxHeight / 2 - sines[i] * maxHeight / 2 * .95);
        g.setColor(Color.RED);

        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hstep) + step;
            int x2 = (int) (i * hstep) + step;
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
        }
    }
    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        for (int i = 0; i < 100 ; i++) {
            step++;
            repaint();
            try {TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

public class MovingSineWave extends JFrame {
    private SineDraw sines = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 1);

    public MovingSineWave() {
        add(sines);

        adjustCycles.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sines.setCycles(
                        ((JSlider) e.getSource()).getValue());
            }
        });
        add(BorderLayout.SOUTH, adjustCycles);
    }

    public static void main(String[] args) {
        run(new MovingSineWave(), 700, 400);
    }
} ///:~