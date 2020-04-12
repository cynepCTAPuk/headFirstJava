package org.stepic.java.robot;

class Robot implements RobotConnection {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction; // текущее направление взгляда
    }

    public int getX() {
        return x; // текущая координата X
    }

    public int getY() {
        return y; // текущая координата Y
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

    public static void moveRobot(Robot robot, int toX, int toY) {
        int xx = toX - robot.getX();
        int yy = toY - robot.getY();
        if (xx > 0) {
            switch (robot.getDirection()) {
                case UP:
                    robot.turnRight();
                    break;
                case DOWN:
                    robot.turnLeft();
                    break;
                case LEFT:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
                default:
            }
            for (int i = 0; i < xx; i++) {
                robot.stepForward();
            }
        } else if (xx < 0) {
            switch (robot.getDirection()) {
                case UP:
                    robot.turnLeft();
                    break;
                case DOWN:
                    robot.turnRight();
                    break;
                case RIGHT:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
                default:
            }
            for (int i = 0; i < -xx; i++) {
                robot.stepForward();
            }
        }
        if (yy > 0) {
            switch (robot.getDirection()) {
                case DOWN:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
                case LEFT:
                    robot.turnRight();
                    break;
                case RIGHT:
                    robot.turnLeft();
                    break;
                default:
            }
            for (int i = 0; i < yy; i++) {
                robot.stepForward();
            }
        } else if (yy < 0) {
            switch (robot.getDirection()) {
                case UP:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
                case LEFT:
                    robot.turnLeft();
                    break;
                case RIGHT:
                    robot.turnRight();
                    break;
                default:
            }
            for (int i = 0; i < -yy; i++) {
                robot.stepForward();
            }
        }
    }

    @Override
    public void moveRobotTo(int x, int y) {
        moveRobot(this, x, y);
    }

    @Override
    public void close() {
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int i = 0;
        while (true) {
            if (++i > 3) {
                throw new RobotConnectionException("Connection failed");
            }
            RobotConnection robotConnection = null;
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException ignored) {
            } finally {
                try {
                    if (robotConnection != null) {
                        robotConnection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
