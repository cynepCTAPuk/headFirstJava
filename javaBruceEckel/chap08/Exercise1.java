package chap08;

import static util.Print.print;

public class Exercise1 {
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

class Cycle {
    void ride() { print("ride"); }
}
class Unicycle extends Cycle{
    void ride(){ print("ride by Unicycle"); }
}
class Bicycle extends Cycle{
    void ride(){ print("ride by Bicycle"); }
}
class Tricycle extends Cycle{
    void ride(){ print("ride by Tricycle"); }
}
