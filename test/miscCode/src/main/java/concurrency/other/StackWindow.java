package concurrency.other;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StackWindow extends JFrame implements Thread.UncaughtExceptionHandler {
    private JTextArea textArea;

    public StackWindow(String title, final int width, final int height) {
        super(title);
        setSize(width, height);
        textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        textArea.setEditable(false);
        getContentPane().add(pane);
    }

    public void uncaughtException(Thread thread, Throwable exception) {
//        System.out.println(thread.getName());
        addStackInfo(exception);
    }

    public void addStackInfo(final Throwable exception) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Bring window to foreground
                setVisible(true);
                toFront();
                // Convert stack dump to string
                StringWriter sw = new StringWriter();
                PrintWriter out = new PrintWriter(sw);
                exception.printStackTrace(out);
                // Add string to end of text area
                textArea.append(sw.toString());
            }
        });
    }
}