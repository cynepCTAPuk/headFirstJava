package chap03_decorator.size.coffee;

import chap03_decorator.size.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
