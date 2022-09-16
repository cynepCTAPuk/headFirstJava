package oop.innerClass;

public class BicycleTest {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("Peugeot", 120);
        SportSeat peugeotSportSeat = new SportSeat(bicycle);
        peugeotSportSeat.down();
        peugeotSportSeat.up();
    }
}
