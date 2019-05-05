package chap7_facade.car;

public class Car {
    Engine engine;

    public Car() {

    }

    public void updateDashboardDisplay() {

    }

    public void start(Key key) {
        Doors doors = new Doors();
        boolean authorized = key.turns();
        if (authorized) {
            engine.start();
            updateDashboardDisplay();
            doors.lock();
        }
    }
}
