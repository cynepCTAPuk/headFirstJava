package chap07_facade.car;

public class Car {
    Engine engine;

    public Car(Engine engine) {this.engine = engine;}
    public void updateDashboardDisplay() {System.out.println("Dashboard Display");}

    public void start(Key key) {
        Doors doors = new Doors();
        boolean authorized = key.turns();
        if (authorized) {
            engine.start();
            updateDashboardDisplay();
            doors.lock();
        }
    }

    public static void main(String[] args) {
        Car car = new Car(new Engine());
        car.start(new Key());
    }
}
