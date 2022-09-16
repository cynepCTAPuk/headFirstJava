package games.task3410.view;

import games.task3410.controller.Controller;
import games.task3410.controller.EventListener;
import games.task3410.model.GameObjects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void setEventListener(EventListener eventListener) {
        field.setEventListener(eventListener);
    }

    public GameObjects getGameObjects() {
        return controller.getGameObjects();
    }

    public void update() {
        field.repaint();
    }

    public void completed(int level) {
        update();
        JOptionPane.showMessageDialog(this, "Level " + level + " is finished!");
        controller.startNextLevel();
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");

        setVisible(true);
    }
}
