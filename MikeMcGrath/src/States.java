package src;

import javax.swing.*;
import java.awt.event.*;

public class States extends JFrame implements ItemListener {
    JPanel pnl = new JPanel();
    String[] styles = {"В глубокой форме", "Для гурманов", "Тонкая"};
    JComboBox<String> box = new JComboBox<>(styles);
    JRadioButton rad1 = new JRadioButton("Белое");
    JRadioButton rad2 = new JRadioButton("Красное");
    ButtonGroup wines = new ButtonGroup();
    JCheckBox chk = new JCheckBox("Пеперони");
    JTextArea txtArea = new JTextArea(5, 38);

    public States() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        wines.add(rad1);
        wines.add(rad2);
        pnl.add(rad1);
        pnl.add(rad2);
        pnl.add(chk);
        pnl.add(box);
        pnl.add(txtArea);
        rad1.addItemListener(this);
        rad2.addItemListener(this);
        chk.addItemListener(this);
        box.addItemListener(this);

        setVisible(true);
    }

    public void itemStateChanged(ItemEvent event) {
        if (event.getItemSelectable() == rad1)
            txtArea.setText("Выбрано белое вино\n");
        if (event.getItemSelectable() == rad2)
            txtArea.setText("Выбрано красное вино\n");
        if ((event.getItemSelectable() == chk) && (event.getStateChange() == ItemEvent.SELECTED))
            txtArea.append("Выбрана Пеперони\n");
        if ((event.getItemSelectable() == box) && (event.getStateChange() == ItemEvent.SELECTED))
            txtArea.append("Выбрана " + event.getItem().toString() + "\n");
    }

    public static void main(String[] args) {
        States gui = new States();
    }
}
