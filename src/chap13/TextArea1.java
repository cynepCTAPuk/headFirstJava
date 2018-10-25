package chap13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea1 implements ActionListener {
    JTextArea text;

    public static void main(String[] args) {
        TextArea1 gui = new TextArea1();
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
        JButton button = new JButton("Just Click It");
        button.addActionListener(this);
        text = new JTextArea(10, 30);
        Font font = new Font("Monospaced", Font.PLAIN, 14);
        text.setFont(font);
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scroller.setHorizontalScrollBarPolicy((ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(widthFrame, heightFrame);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        text.append("button clicled \n");

    }
}
