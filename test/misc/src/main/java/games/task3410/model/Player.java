package games.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        int x0 = getX() - getWidth() / 2;
        int y0 = getY() - getHeight() / 2;

        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x0, y0, getWidth(), getHeight());

        graphics.setColor(Color.BLACK);
        graphics.drawOval(x0, y0, getWidth(), getHeight());
    }
}
