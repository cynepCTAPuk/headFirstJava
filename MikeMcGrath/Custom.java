import javax.swing.*;
import java.awt.*;

public class Custom extends JFrame {
    JPanel pnl = new JPanel();
    JLabel lbl1 = new JLabel("Пользовательский задний фон");
    JLabel lbl2 = new JLabel("Пользовательский передний фон");
    JLabel lbl3 = new JLabel("Пользовательский шрифт");
    Color customColor = new Color(255, 0, 0);
    Font customFont = new Font("Serif", Font.ITALIC, 32);


    public Custom() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        lbl1.setOpaque(true);
        lbl1.setBackground(Color.YELLOW);
        lbl2.setForeground(customColor);
        lbl3.setFont(customFont);
        pnl.add(lbl1);
        pnl.add(lbl3);
        pnl.add(lbl2);

        setVisible(true);
    }

    public static void main(String[] args) {
        Custom gui = new Custom();
    }
}
