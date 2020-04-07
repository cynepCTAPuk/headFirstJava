package robot;

class Robot1 {
    private int x;
    private int y;
    private Direction direction;

    public Robot1(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static void moveRobot(Robot1 robot, int toX, int toY) {
        int steps = 1;
        int s = 0;
        while (robot.getX() != toX || robot.getY() != toY) {
            if (s == 0) {
                robot.turnLeft();
                steps++;
                s = steps / 2;
            }
            robot.stepForward();
            s--;
        }
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

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
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
