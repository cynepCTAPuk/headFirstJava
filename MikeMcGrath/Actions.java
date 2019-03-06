import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Actions extends JFrame implements ActionListener {
    JPanel pnl = new JPanel();
    JButton btn1 = new JButton("Кнопка 1");
    JButton btn2 = new JButton("Кнопка 2");
    JTextArea txtArea = new JTextArea(5, 38);

    public Actions() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(txtArea);
        btn2.setEnabled(false);
        txtArea.setText("Кнопка 2 деактивирована");
        txtArea.setBackground(Color.BLUE);
        txtArea.setForeground(Color.WHITE);
        txtArea.setEditable(false);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn1) {
            btn2.setEnabled(true);
            btn1.setEnabled(false);
            txtArea.setBackground(Color.RED);
        }
        if (event.getSource() == btn2) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            txtArea.setBackground(Color.BLUE);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        txtArea.setText(event.getActionCommand() + " Нажата и деактивирована");
    }

    public static void main(String[] args) {
        Actions gui = new Actions();
    }
}
