package org.stepic.java.robot;

public class RobotConnectionManagerImp implements RobotConnectionManager{
    @Override
    public RobotConnection getConnection() {
        return new RobotConnection() {
            @Override
            public void moveRobotTo(int x, int y) {

            }

            @Override
            public void close() throws Exception {

            }
        };
    }
}
