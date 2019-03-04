//: chap22_gui/Faces.java
// Icon behavior in JButtons.
package chap22_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;
public class Faces extends JFrame {
    private static Icon[] faces;
    private JButton jb1, jb2 = new JButton("Disable");
    private boolean mad = false;
    public Faces() {
        faces = new Icon[]{
                new ImageIcon(getClass().getResource("Face0.gif")),
                new ImageIcon(getClass().getResource("Face1.gif")),
                new ImageIcon(getClass().getResource("Face2.gif")),
                new ImageIcon(getClass().getResource("Face3.gif")),
                new ImageIcon(getClass().getResource("Face4.gif")),
        };
        jb1 = new JButton("JButton", faces[4]);
        setLayout(new FlowLayout());
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(mad) {
                    jb1.setIcon(faces[3]);
                    mad = false;
                } else {
                    jb1.setIcon(faces[0]);
                    mad = true;
                }
                jb1.setVerticalAlignment(JButton.TOP);
                jb1.setHorizontalAlignment(JButton.LEFT);
            }
        });
        jb1.setRolloverEnabled(true);
        jb1.setRolloverIcon(faces[1]);
        jb1.setPressedIcon(faces[2]);
        jb1.setDisabledIcon(faces[3]);
        jb1.setToolTipText("Yow!");
        add(jb1);
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jb1.isEnabled()) {
                    jb1.setEnabled(false);
                    jb2.setText("Enable");
                } else {
                    jb1.setEnabled(true);
                    jb2.setText("Disable");
                }
            }
        });
        add(jb2);
    }
    public static void main(String[] args) {
        run(new Faces(), 250, 250);
    }
} ///:~