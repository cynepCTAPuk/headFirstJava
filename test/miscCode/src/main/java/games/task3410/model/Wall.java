package games.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends CollisionObject  {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int x0 = getX() - getWidth() / 2;
        int y0 = getY() - getHeight() / 2;

        graphics.setColor(new Color(102,51,0));
        graphics.fillRect(x0, y0, getWidth(), getHeight());

/*
        graphics.setColor(Color.black);
        graphics.drawRect(x0, y0, getWidth(), getHeight());
*/
    }
}
