package chap03_decorator.no_size.coffee;

import chap03_decorator.no_size.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
