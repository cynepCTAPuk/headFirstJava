package src;

import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Mouse extends JFrame implements MouseListener, MouseMotionListener {
    JPanel pnl = new JPanel();
    JTextArea txtArea = new JTextArea(8, 38);
    int x, y;

    public Mouse() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add(txtArea);
        txtArea.addMouseMotionListener(this);
        txtArea.addMouseListener(this);

        setVisible(true);
    }

    public void mouseMoved(MouseEvent event) {
        x = event.getX();
        y = event.getY();
    }

    public void mouseDragged(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
        txtArea.setText("Мышь в окне\n");
        txtArea.setOpaque(true);
        txtArea.setForeground(Color.BLACK);
        txtArea.setBackground(Color.WHITE);
    }

    public void mouseExited(MouseEvent event) {
        txtArea.setText("Мышь вне окна\n");
        txtArea.setOpaque(true);
        txtArea.setBackground(Color.GRAY);
        txtArea.setForeground(Color.YELLOW);
    }

    public void mousePressed(MouseEvent event) {
        txtArea.append("Кнопка нажата, когда указатель в позиции\nX: " + x + "\nY: " + y + "\n");
    }

    public void mouseReleased(MouseEvent event) {
        txtArea.append("Кнопка мыши отпущена\n");
    }

    public void mouseClicked(MouseEvent event) {
    }

    public static void main(String[] args) {
        Mouse gui = new Mouse();
    }
}
