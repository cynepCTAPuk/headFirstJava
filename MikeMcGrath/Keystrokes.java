import javax.swing.*;
import java.awt.event.*;

public class Keystrokes extends JFrame implements KeyListener {
    JPanel pnl = new JPanel();
    JTextField field = new JTextField(38);
    JTextArea txtArea = new JTextArea(5, 38);

    public Keystrokes() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add(field);
        pnl.add(txtArea);
        field.addKeyListener(this);

        setVisible(true);
    }

    public void keyPressed(KeyEvent event) {
        txtArea.setText("Нажата клавиша");
    }

    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();
        txtArea.append("\nКод клавиши : " + event.getKeyCode());
        txtArea.append("\nТекст клавиши : " + event.getKeyText(keyCode));
    }

    public void keyTyped(KeyEvent event) {
        txtArea.append("\nСимвол : " + event.getKeyChar());
    }

    public static void main(String[] args) {
        Keystrokes gui = new Keystrokes();
    }
}
