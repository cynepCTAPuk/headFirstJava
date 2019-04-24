package chap03_decorator.Size.condiment;

import chap03_decorator.Size.Beverage;
import chap03_decorator.Size.CondimentDecorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (beverage.getSize() == Size.TALL) {
            cost += .20;
        } else if (beverage.getSize() == Size.CRANDE) {
            cost += .25;
        } else if (beverage.getSize() == Size.VENTI) {
            cost += .30;
        }
        return cost;
    }
}
