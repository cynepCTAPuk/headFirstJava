package swing;import javax.swing.*;import java.awt.*;public class Animate {    int x = 1;    int y = 1;    public static void main(String[] args) {        Animate gui = new Animate();        gui.go();    } //end main    public void go() {        JFrame frame = new JFrame();        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        frame.setLocation(500, 200);        MyDrawP drawP = new MyDrawP();        frame.getContentPane().add(drawP);        frame.setSize(500, 270);        frame.setVisible(true);        while (true) {            drawP.repaint();            for (int i = 0; i < 124; i++, x++, y++) {                x++;                drawP.repaint();                try {                    Thread.sleep(50);                } catch (Exception ex) {                } //end try-catch            } // end for i(0 - 124)        }    } // end go() method    class MyDrawP extends JPanel {        public void paintComponent(Graphics g) {            g.setColor(Color.white);            g.fillRect(0, 0, 500, 250);            g.setColor(Color.blue);            g.fillRect(x, y, 500 - x * 2, 250 - y * 2);        } //end paintComponent(Graphics g) method    } //end inner class MyDrawP} //end outer class swing.Animate