package chap03_decorator.Size.condiment;

import chap03_decorator.Size.Beverage;
import chap03_decorator.Size.CondimentDecorator;

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (beverage.getSize() == Size.TALL) {
            cost += .15;
        } else if (beverage.getSize() == Size.CRANDE) {
            cost += .20;
        } else if (beverage.getSize() == Size.VENTI) {
            cost += .25;
        }
        return cost;
    }
}
