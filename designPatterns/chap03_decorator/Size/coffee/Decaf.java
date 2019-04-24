package chap03_decorator.Size.coffee;

import chap03_decorator.Size.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
