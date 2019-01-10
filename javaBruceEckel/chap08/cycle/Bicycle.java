package chap08.cycle;

import static util.Print.print;

class Bicycle extends Cycle{
    @Override void ride(){ print("ride by Bicycle"); }
    @Override void wheels() { print("Two wheels"); }
    void balance(){ print("Balance on Two wheels"); }
}
