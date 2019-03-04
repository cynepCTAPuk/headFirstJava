package chap22_gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * https://coderanch.com/t/652937/java/rotated-rectangle-points
 * @author Piet
 */
public class Test extends JPanel implements MouseListener {
    Ellipse2D e;
    Shape e1, s, e2;
    Rectangle2D boundRect;
    public static void main(String[] args) { new Test();}

    public Test() {
        e = new Ellipse2D.Double(100, 150, 100, 200);
        double angle = Math.PI / 4;
        AffineTransform at = new AffineTransform();
        at.rotate(angle, e.getCenterX(), e.getCenterY());
        s = at.createTransformedShape(e);
        boundRect = s.getBounds2D();
        e1 = new Ellipse2D.Double(
                boundRect.getX(), boundRect.getY(),
                boundRect.getWidth(), boundRect.getHeight()
        );
        addMouseListener(this);
        setPreferredSize(new Dimension(500, 500));
        JTextField tf = new JTextField("black: e || blue: s || red: e1 || green: boundRect");
        JFrame frame = new JFrame("Some title");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.getContentPane().add(tf, BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(e);
        g2.setColor(Color.blue);
        g2.draw(s);
        g2.setColor(Color.red);
        g2.draw(e1);
        g2.setColor(Color.GREEN);
        g2.draw(boundRect);
    }
    public void mouseClicked(MouseEvent m) {
        Point p = new Point(m.getX(), m.getY());
        if (e1.contains(p)) { JOptionPane.showConfirmDialog(null,
                "Meso","Meso Description", JOptionPane.DEFAULT_OPTION);
        }
    }
    public void mouseEntered(MouseEvent arg0) { }
    public void mouseExited(MouseEvent arg0) { }
    public void mousePressed(MouseEvent arg0) { }
    public void mouseReleased(MouseEvent arg0) { }
}
