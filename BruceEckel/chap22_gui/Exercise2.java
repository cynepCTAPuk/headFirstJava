package chap22_gui;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;
import java.util.concurrent.TimeUnit;

class HelloLabel1 extends JFrame {
	private static Random rand = new Random();
	JLabel[] labels;
	HelloLabel1() {
		super("Hello Swing");
		setLayout(new FlowLayout());
		int size = rand.nextInt(5) + 1;
		labels = new JLabel[size];
		for(int i = 0; i < size; i++) {
			labels[i] = new JLabel("Label#\n" + i);
			add(labels[i]);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocation(500,400);
		setVisible(true);
	}
}

public class Exercise2 {
	public static HelloLabel1 hl;
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				hl = new HelloLabel1();
			}
		});
		TimeUnit.SECONDS.sleep(3);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for(int i = 0; i < hl.labels.length; i++) {
					hl.labels[i].setText("Changed#\n" + i);
				}
			}
		});
	}
}

/* Execute to see output */
