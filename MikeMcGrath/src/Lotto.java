package src;

import javax.swing.*;
import java.awt.event.*;
/*
Синтаксис команды Операция
jar cf jar-файл входные файлы
    Создание JAR-архива
jar cfe jar-файл точка_входа входные файлы
    Создание JAR-архива с указанием точки входа в приложение
jar tf jar-файл
    Просмотр содержимого JAR-архива
jar uf jar-файл
    Обновление содержимого JAR-архива
jar ufm jar-файл файл_атрибутов
    Обновление содержимого манифеста JAR-архива с добавлением в него атрибутов
jar xf jar-файл
    Извлечение содержимого JAR-архива
jar xf jar-файл архивный_файл
    Извлечение определенного файла из содержимого JAR-архива
 */
public class Lotto extends JFrame implements ActionListener {
    // Компоненты.
    ClassLoader ldr = this.getClass().getClassLoader();
    java.net.URL iconURL = ldr.getResource("Lotto.jpg");
    ImageIcon icon = new ImageIcon(iconURL);
    JLabel img = new JLabel(icon);
    JTextField txt = new JTextField("", 18);
    JButton btn = new JButton("Show Happy Numbers");
    JPanel pnl = new JPanel();

    // Конструктор.
    public Lotto() {
        super("Lotto");
        setSize(270, 290);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnl.add(img);
        pnl.add(txt);
        pnl.add(btn);
        btn.addActionListener(this);
        add(pnl);
        setVisible(true);
    }

    // Обработчик событий.
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btn) {
            String str = "";
            for (int i = 0; i < 6; i++) {
                str += " " + ((int) (49 * Math.random()) + 1) + " ";
            }
            txt.setText(str);
        }
    }

    // Точка входа.
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
    }
}