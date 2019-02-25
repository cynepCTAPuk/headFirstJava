//: gui/ColorChooserTest.java
// Demonstration of File dialog boxes.
package gui.Exercise29;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static util.SwingConsole.*;

public class ColorChooserTest extends JFrame {
    private JTextField
            backColor = new JTextField(),
            fontColor = new JTextField();
    private JButton button = new JButton("Choose Color");
    public ColorChooserTest() {
        JPanel p = new JPanel();
        button.addActionListener(new ChooseColor());
        p.add(button);
        add(p, BorderLayout.SOUTH);
        backColor.setEditable(false);
        fontColor.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        p.add(backColor);
        p.add(fontColor);
        add(p, BorderLayout.NORTH);
    }
    class ChooseColor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JColorChooser c = new JColorChooser();
            Color color = c.showDialog(ColorChooserTest.this,
                    "Choose Background Color", button.getBackground());
            Color textColor;
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            double y = (299 * r + 587 * g + 114 * b) / 1000;
            textColor = (y >= 128) ? Color.BLACK : Color.WHITE;
            button.setBackground(color);
            button.setForeground(textColor);

            backColor.setText(color.toString());
            fontColor.setText(textColor.toString());

        }
    }
    public static void main(String[] args) {
        run(new ColorChooserTest(), 250, 150);
    }
} ///:~