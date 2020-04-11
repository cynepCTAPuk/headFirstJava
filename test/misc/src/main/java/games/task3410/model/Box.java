package games.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
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

        graphics.setColor(Color.ORANGE);
        graphics.fillRect(x0, y0, getWidth(), getHeight());

        graphics.setColor(Color.BLACK);
        graphics.drawRect(x0, y0, getWidth(), getHeight());
        graphics.drawLine(x0, y0, x0 + getWidth(), y0 + getHeight());
        graphics.drawLine(x0, y0 + getHeight(), x0 + getWidth(), y0);
    }
}
