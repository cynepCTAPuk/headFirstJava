package chap12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerButton {
    JFrame frame;
    JButton b;

    public static void main(String[] args) {
        InnerButton gui = new InnerButton();
        gui.go();
    }

    public void go() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((width / 2 - 500 / 2), (height / 2 - 500 / 2));

        b = new JButton("A");
        b.addActionListener(new BListener());
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, b);
        frame.setSize(500, 500 + 20);
        frame.setVisible(true);
    }

    class BListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (b.getText().equals("A")) {
                b.setText("B");
            } else {
                b.setText("A");
            }
            frame.repaint();
        }
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight()); //Change oval color randomly

            int[] colorRect = new int[]{(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)};
            int[] colorOval = new int[]{(int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)};

            Color color = new Color(colorRect[0], colorRect[1], colorRect[2]);
            g.setColor(color);
            g.fillRect(0, 0, this.getWidth(), this.getHeight()); //Change oval color randomly

            color = new Color(colorOval[0], colorOval[1], colorOval[2]);
            g.setColor(color);
            int[] sizeOval = {200, 200}; // x = size[0], y = size[1]
            g.fillOval((this.getWidth() / 8), (this.getHeight() / 8), this.getWidth() * 3 / 4, this.getWidth() * 3 / 4);
        }
    }
}
