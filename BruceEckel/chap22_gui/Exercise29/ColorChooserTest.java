//: chap22_gui/ColorChooserTest.java
// Demonstration of File dialog boxes.
package chap22_gui.Exercise29;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;

public class ColorChooserTest extends JFrame {
    private JTextField
            backColorText = new JTextField(),
            fontColorText = new JTextField();
    private JButton button = new JButton("Choose Color");
    public ColorChooserTest() {
        JPanel panelA = new JPanel();
        panelA.setBackground(Color.BLACK);
        button.addActionListener(new ChooseColor());
        panelA.add(button);
        add(panelA, BorderLayout.SOUTH);
        backColorText.setEditable(false);
        fontColorText.setEditable(false);
        JPanel panelB = new JPanel();
        panelB.setLayout(new GridLayout(2,1));
        panelB.setBackground(Color.CYAN);
        panelB.add(backColorText);
        panelB.add(fontColorText);
        add(panelB, BorderLayout.NORTH);
    }
    class ChooseColor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color backgroundColor;
            Color textColor;
            backgroundColor = new JColorChooser().showDialog(ColorChooserTest.this,
                    "Choose Background Color", button.getBackground());
            int r = backgroundColor.getRed();
            int g = backgroundColor.getGreen();
            int b = backgroundColor.getBlue();
            int y = (299 * r + 587 * g + 114 * b) / 1000;
            textColor = (y >= 128) ? Color.BLACK : Color.WHITE;
            button.setBackground(backgroundColor);
            button.setForeground(textColor);
            backColorText.setText(backgroundColor.toString());
            fontColorText.setText(textColor.toString());
        }
    }
    public static void main(String[] args) {
        run(new ColorChooserTest(), 250, 150);
    }
} ///:~