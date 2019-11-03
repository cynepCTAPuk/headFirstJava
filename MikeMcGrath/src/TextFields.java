package src;

import javax.swing.*;

public class TextFields extends JFrame {
    JPanel jPanel = new JPanel();
    JTextField txt1 = new JTextField( 38 ) ;
    JTextField txt2 = new JTextField( "Текст по умолчанию" , 38 ) ;
    JTextArea txtArea = new JTextArea( 5 , 37 ) ;
    JScrollPane pane = new JScrollPane( txtArea ) ;

    public TextFields() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(jPanel);
        txtArea.setLineWrap( true ) ;
        txtArea.setWrapStyleWord( true ) ;
        pane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ) ;
        jPanel.add( txt1 ) ;
        jPanel.add( txt2 ) ;
        jPanel.add( pane ) ;
        setVisible(true);
    }

    public static void main(String[] args) {
        TextFields gui = new TextFields();
    }
}
