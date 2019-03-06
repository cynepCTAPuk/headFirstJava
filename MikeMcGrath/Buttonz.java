import javax.swing.*;

public class Buttonz extends JFrame {
    JPanel jPanel = new JPanel();
    ClassLoader ldr = this.getClass().getClassLoader() ;
    java.net.URL tickURL = ldr.getResource( "c:/000/529.gif" ) ;
    java.net.URL crossURL = ldr.getResource( "c:/000/539.gif" +
            ".0" ) ;

    ImageIcon tick = new ImageIcon( tickURL ) ;
    ImageIcon cross = new ImageIcon( crossURL ) ;

    JButton btn = new JButton( "Нажми меня" ) ;
    JButton tickBtn = new JButton( tick ) ;
    JButton crossBtn = new JButton( "СТОП" , cross ) ;

    public Buttonz() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 400);
        setLocationRelativeTo(null);
        add(jPanel);
        jPanel.add(btn);
        jPanel.add(tickBtn);
        jPanel.add(crossBtn);
        setVisible(true);
    }

    public static void main(String[] args) {
        Buttonz gui = new Buttonz();
    }
}
