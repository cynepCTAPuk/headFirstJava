package src;

import javax.swing.*;

public class Buttons extends JFrame {
    JPanel jPanel = new JPanel();
    ImageIcon tick = new ImageIcon( "c:/000/529.gif" ) ;
    ImageIcon cross = new ImageIcon( "c:/000/539.gif" ) ;
    JButton btn = new JButton( "Нажми меня" ) ;
    JButton tickBtn = new JButton( tick ) ;
    JButton crossBtn = new JButton( "СТОП" , cross ) ;

    public Buttons() {
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
        Buttons gui = new Buttons();
    }
}
