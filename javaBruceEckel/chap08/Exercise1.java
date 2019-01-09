package chap08;

import static util.Print.print;

public class Exercise1 {
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        unicycle.ride();
        bicycle.ride();
        tricycle.ride();
    }
}

class Cycle {
    void ride() { print("ride"); }
}
class Unicycle {
    void ride(){ print("ride Unicycle"); }
}
class Bicycle {
    void ride(){ print("ride Bicycle"); }
}
class Tricycle {
    void ride(){ print("ride Tricycle"); }
}
