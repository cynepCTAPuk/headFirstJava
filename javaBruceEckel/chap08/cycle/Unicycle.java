package chap08.cycle;

import static util.Print.print;

class Unicycle extends Cycle{
    void ride(){ print("ride by Unicycle"); }
    @Override void wheels() { print("One wheels"); }
}
