import javax.swing.*;

public class Items extends JFrame {
    JPanel jPanel = new JPanel();
    String[] toppings = {"Пеперони", "Грибная", "С ветчиной", "Томатная"};
    String[] styles = {"В глубокой форме", "Для гурманов", "Тонкая"};
    JCheckBox chk1 = new JCheckBox(toppings[0]);
    JCheckBox chk2 = new JCheckBox(toppings[1], true);
    JCheckBox chk3 = new JCheckBox(toppings[2]);
    JCheckBox chk4 = new JCheckBox(toppings[3]);
    JComboBox<String> box1 = new JComboBox<>(styles);
    JList<String> lst1 = new JList<>(toppings);

    public Items() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(jPanel);
        jPanel.add( chk1 ) ;
        jPanel.add( chk2 ) ;
        jPanel.add( chk3 ) ;
        jPanel.add( chk4 ) ;
        box1.setSelectedIndex( 0 ) ;
        jPanel.add( box1 ) ;
        jPanel.add( lst1 ) ;
        setVisible(true);
    }

    public static void main(String[] args) {
        Items gui = new Items();
    }
}
