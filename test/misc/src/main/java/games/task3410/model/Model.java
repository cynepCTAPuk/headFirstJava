package games.task3410.model;

import games.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    //    private final LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));
    private final LevelLoader levelLoader = new LevelLoader(Paths.get("./src/main/java/"
            + getClass().getPackage().getName()
            .replace('.', '/')
            .replace("model", "res/levels.txt")));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall w : gameObjects.getWalls())
            if (gameObject.isCollision(w, direction))
                return true;
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Player player = gameObjects.getPlayer();
        for (Box b : getGameObjects().getBoxes()) {
            if (player.isCollision(b, direction)) {
                if (checkWallCollision(b, direction))
                    return true;
                for (Box box : getGameObjects().getBoxes()) {
                    if (b.isCollision(box, direction))
                        return true;
                }
                switch (direction) {
                    case LEFT:
                        b.move(-FIELD_CELL_SIZE, 0);
                        break;
                    case RIGHT:
                        b.move(FIELD_CELL_SIZE, 0);
                        break;
                    case UP:
                        b.move(0, -FIELD_CELL_SIZE);
                        break;
                    case DOWN:
                        b.move(0, FIELD_CELL_SIZE);
                        break;
                }
                break;
            }
        }
        return false;
    }

    public void checkCompletion() {
        for (Home h : getGameObjects().getHomes()) {
            boolean unChecked = true;
            int x = h.getX();
            int y = h.getY();
            for (Box b : gameObjects.getBoxes()) {
                if (b.getX() == x && b.getY() == y) {
                    unChecked = false;
                    break;
                }
            }
            if (unChecked) return;
        }
        eventListener.levelCompleted(currentLevel);
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction)) return;
        if (checkBoxCollisionAndMoveIfAvailable(direction)) return;
        switch (direction) {
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
                break;
        }
        checkCompletion();
    }
}
