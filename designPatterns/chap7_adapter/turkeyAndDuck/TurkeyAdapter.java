package chap7_adapter.turkeyAndDuck;

import chap7_adapter.turkeyAndDuck.Duck;
import chap7_adapter.turkeyAndDuck.Turkey;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}