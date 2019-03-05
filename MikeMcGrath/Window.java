import javax.swing.*;

public class Window extends JFrame {
    JPanel jPanel = new JPanel();

    public Window() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(jPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Window gui = new Window();
    }
}
