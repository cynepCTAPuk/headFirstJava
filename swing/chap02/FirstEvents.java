// FirstEvents.java
// События - нажатия клавиш на клавиатуре
package chap02;

import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
    FirstEvents() {
        super("FirstEvents");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии окна - выход
        addKeyListener(new KeyL()); // регистрируем нашего слушателя
        setSize(200,200);
        setLocation(300, 300);
        setVisible(true); // выводим окно на экран
    }
    public static void main(String[] args) { new FirstEvents();}
}

// этот класс будет получать извещения о событиях
class KeyL implements KeyListener {
    // печать символа
    public void keyTyped(KeyEvent k) { System.out.println(k);}
    // нажатие клавиши
    public void keyPressed(KeyEvent k) { System.out.println(k);}
    // отпускание нажатой клавиши public void
    public void keyReleased(KeyEvent k) { System.out.println(k);}
}