package chap08.cycle;

public class Cycles {
    static void ride(Cycle c) { c.ride(); }
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Cycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        ride(cycle);
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}

