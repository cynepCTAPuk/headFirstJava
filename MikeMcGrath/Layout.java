import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    JPanel pnl = new JPanel();
    JPanel grid = new JPanel(new GridLayout(2, 2));
    Container contentPane = getContentPane();

    public Layout() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add(new JButton("Да"));
        pnl.add(new JButton("Нет"));
        pnl.add(new JButton("Отмена"));
        grid.add(new JButton("1"));
        grid.add(new JButton("2"));
        grid.add(new JButton("3"));
        grid.add(new JButton("4"));
        contentPane.add("North", pnl);
        contentPane.add("Center", grid);
        contentPane.add("West", new JButton("Запад"));
//        contentPane.add("South", new JButton("Юг"));
//        contentPane.add("East", new JButton("Восток"));
        setVisible(true);
    }

    public static void main(String[] args) {
        Layout gui = new Layout();
    }
}
