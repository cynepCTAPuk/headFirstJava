package chap08_polymorphism.cycle;

import static util.Print.print;

class Tricycle extends Cycle{
    void ride(){ print("ride by Tricycle"); }
    @Override void wheels() { print("Three wheels"); }
}
