//: gui/Progress.java
// Using sliders, progress bars and progress monitors.
package gui.Exercise32;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import static util.SwingConsole.*;
public class ProgressListener extends JFrame {
    private JProgressBar pb = new JProgressBar();
    private JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
    public ProgressListener() {
        setLayout(new GridLayout(2,1));
        add(pb);
        sb.setValue(0);
        sb.setPaintLabels(true);
        sb.setPaintTicks(true);
        sb.setMajorTickSpacing(10);
        sb.setMinorTickSpacing(5);
        sb.setBorder(new TitledBorder("Slide Me"));
        add(sb);
        sb.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                pb.setValue(sb.getValue());
            }
        });
    }
    public static void main(String[] args) { run(new ProgressListener(), 300, 200);}
} ///:~