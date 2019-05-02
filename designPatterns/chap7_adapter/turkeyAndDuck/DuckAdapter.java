package chap7_adapter.turkeyAndDuck;

import chap7_adapter.turkeyAndDuck.Duck;
import chap7_adapter.turkeyAndDuck.Turkey;

public class DuckAdapter implements Turkey {
    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    public void gobble() {
        duck.quack();
    }

    public void fly() {
        duck.fly();
    }
}