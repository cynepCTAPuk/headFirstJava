package book.chap13;

import javax.swing.*;
import java.awt.*;

public class Label1 {
    public static void main(String[] args) {
        Label1 gui = new Label1();
        gui.go();
    }

    public void go() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        int widthFrame = 500;
        int heightFrame = 500;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((width / 2 - widthFrame / 2), (height / 2 - heightFrame / 2));

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("click me");
        panel.add(button);

        JTextField fieldOne = new JTextField(20);
        JTextField fieldTwo = new JTextField("Your name");

        JLabel label = new JLabel();

        frame.getContentPane().add(BorderLayout.NORTH, fieldOne);
        frame.getContentPane().add(BorderLayout.SOUTH, fieldTwo);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(widthFrame, heightFrame);
        frame.setVisible(true);
    }
}
