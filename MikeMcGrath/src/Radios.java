package src;

import javax.swing.*;

public class Radios extends JFrame {
    JPanel pnl = new JPanel();
    JRadioButton rad1 = new JRadioButton("Красное", true);
    JRadioButton rad2 = new JRadioButton("Розовое");
    JRadioButton rad3 = new JRadioButton("Белое");
    ButtonGroup wines = new ButtonGroup();

    public Radios() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        wines.add(rad1);
        wines.add(rad2);
        wines.add(rad3);
        pnl.add(rad1);
        pnl.add(rad2);
        pnl.add(rad3);

        setVisible(true);
    }

    public static void main(String[] args) {
        Radios gui = new Radios();
    }
}
