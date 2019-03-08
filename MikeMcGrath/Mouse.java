import javax.swing.*;
import java.awt.event.*;

public class Mouse extends JFrame implements MouseListener, MouseMotionListener {
    JPanel pnl = new JPanel();
    JTextArea txtArea = new JTextArea( 8 , 38 ) ;
    int x , y ;

    public Mouse() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add( txtArea ) ;
        txtArea.addMouseMotionListener( this ) ;
        txtArea.addMouseListener( this ) ;

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

    public void mouseDragged(MouseEvent event) {

    }

    public void mouseMoved(MouseEvent event) {

    }

    public static void main(String[] args) {
        Mouse gui = new Mouse();
    }
}
