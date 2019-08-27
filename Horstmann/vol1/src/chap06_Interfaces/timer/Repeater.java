package chap06_Interfaces.timer;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class Repeater {
    public static void main(String[] args) throws InterruptedException {
        repeatMessage("Hello", 1_000);
        repeatDate(1_000);
        repeatBeep(10_000);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public static void repeatMessage(String text, int delay) {
        ActionListener listener = event -> System.out.println(text);
        new Timer(delay, listener).start();
    }

    public static void repeatDate(int delay) {
        ActionListener listener = event -> System.out.println(new Date());
        new Timer(delay, listener).start();
    }
    public static void repeatBeep(int delay) {
        ActionListener listener = event -> Toolkit.getDefaultToolkit().beep();
        new Timer(delay, listener).start();
    }

}
