import javax.swing.*;

public class Slider extends JFrame {
    JPanel pnl = new JPanel();
    ButtonGroup wines = new ButtonGroup();

    JSlider slider = new JSlider(0, 100);

    public Slider() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        pnl.add(slider);

        setVisible(true);
    }

    public static void main(String[] args) {
        Slider gui = new Slider();
    }
}
