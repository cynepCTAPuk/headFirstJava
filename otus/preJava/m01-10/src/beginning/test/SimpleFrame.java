package beginning.test;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame() {
            {
                add
                        (new JPanel() {
                             {
                                 add
                                         (new JLabel("Хабрахабр?") {
                                              {
//                                                  setBackground(Color.YELLOW);
                                                  setForeground(Color.RED);
                                              }
                                          }
                                         );
                             }
                         }
                        );
            }
        };
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocation(800, 500);
        frame.setVisible(true);
    }
}
