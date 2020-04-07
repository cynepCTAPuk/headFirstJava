package robot;

public class RobotTest {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        Robot.moveRobot(robot, 3, -2);
        System.out.println(robot.getX() + " " + robot.getY() + " " + robot.getDirection());

        Robot1 robot1 = new Robot1(0, 0, Direction.UP);
        Robot1.moveRobot(robot1, 3, -2);
        System.out.println(robot1.getX() + " " + robot1.getY() + " " + robot1.getDirection());

        Robot2 robot2 = new Robot2(0, 0, Direction.UP);
        Robot2.moveRobot(robot2, 3, -2);
        System.out.println(robot2.getX() + " " + robot2.getY() + " " + robot2.getDirection());
    }
}
