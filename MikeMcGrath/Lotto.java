import javax.swing.*;
import java.awt.event.*;

public class Lotto extends JFrame implements ActionListener {
    // Компоненты.
    ClassLoader ldr = this.getClass().getClassLoader();
    java.net.URL iconURL = ldr.getResource("Lotto.jpg");
    ImageIcon icon = new ImageIcon(iconURL);
    JLabel img = new JLabel(icon);
    JTextField txt = new JTextField("", 18);
    JButton btn = new JButton("Show Happy Numbers");
    JPanel pnl = new JPanel();

    // Конструктор.
    public Lotto() {
        super("Lotto");
        setSize(270, 290);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnl.add(img);
        pnl.add(txt);
        pnl.add(btn);
        btn.addActionListener(this);
        add(pnl);
        setVisible(true);
    }

    // Обработчик событий.
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn) {
            String str = "";
            for (int i = 0; i < 6; i++) {
                str += " " + ((int) (49 * Math.random()) + 1) + " ";
            }
            txt.setText(str);
        }
    }

    // Точка входа.
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
    }
}