package chap03_decorator.noSize.coffee;

import chap03_decorator.noSize.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
