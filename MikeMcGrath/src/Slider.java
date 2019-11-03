package src;

import javax.swing.*;
import java.io.*;

public class Slider extends JFrame {
    JPanel pnl = new JPanel();
    JSlider slider = new JSlider(0, 100);
    File dir = new File("c:/000");

    public Slider() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        pnl.add(slider);

        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Slider gui = new Slider();
        System.out.println(gui.dir.getUsableSpace());
    }
}
