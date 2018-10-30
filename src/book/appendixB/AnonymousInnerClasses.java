package book.appendixB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousInnerClasses {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("close frame & exit");
        frame.getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
