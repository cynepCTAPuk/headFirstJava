import javax.swing.*;

public class Labels extends JFrame {
    JPanel jPanel = new JPanel();
    ImageIcon duke1 = new ImageIcon("c:/000/pics/Duke wave 128.png");
    ImageIcon duke2 = new ImageIcon("c:/000/pics/Duke 128.png");
    JLabel lbl1 = new JLabel(duke1);
    JLabel lbl2 = new JLabel("Дюк — талисман технологии Java");
    JLabel lbl3 = new JLabel("Дюк", duke2, JLabel.CENTER);

    public Labels() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(jPanel);
        jPanel.add( lbl1 ) ;
        jPanel.add( lbl2 ) ;
        jPanel.add( lbl3 ) ;
        lbl1.setToolTipText("Дюк — талисман Java");
        lbl3.setHorizontalTextPosition(JLabel.CENTER );
        lbl3.setVerticalTextPosition(JLabel.BOTTOM );

        setVisible(true);
    }

    public static void main(String[] args) {
        Labels gui = new Labels();
    }
}
