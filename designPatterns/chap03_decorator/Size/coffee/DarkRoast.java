package chap03_decorator.Size.coffee;

import chap03_decorator.Size.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
