package org.stepic.java.robot;

class Robot2 {
    private int x;
    private int y;
    private Direction direction;

    public Robot2(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static void moveRobot(Robot2 robot, int toX, int toY) {
        if (toX > robot.getX())
            while (robot.getDirection() != Direction.RIGHT)
                robot.turnRight();
        else if (toX < robot.getX())
            while (robot.getDirection() != Direction.LEFT)
                robot.turnRight();
        while (toX != robot.getX()) robot.stepForward();

        if (toY > robot.getY())
            while (robot.getDirection() != Direction.UP)
                robot.turnRight();
        else if (toY < robot.getY())
            while (robot.getDirection() != Direction.DOWN)
                robot.turnRight();
        while (toY != robot.getY()) robot.stepForward();
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction) {
            case UP:
                this.direction = Direction.RIGHT;
                break;
            case DOWN:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.UP;
                break;
            case RIGHT:
                this.direction = Direction.DOWN;
                break;
            default:
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        if (direction == Direction.UP) y++;
        if (direction == Direction.DOWN) y--;
        if (direction == Direction.LEFT) x--;
        if (direction == Direction.RIGHT) x++;
    }
}
