package chap08_polymorphism.cycle;

import static util.Print.print;

class Unicycle extends Cycle{
    @Override void ride(){ print("ride by Unicycle"); }
    @Override void wheels() { print("One wheel"); }
    void balance(){ print("Balance on One wheel"); }
}
