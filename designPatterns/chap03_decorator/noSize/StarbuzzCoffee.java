package chap03_decorator.noSize;

import chap03_decorator.noSize.coffee.DarkRoast;
import chap03_decorator.noSize.coffee.Espresso;
import chap03_decorator.noSize.coffee.HouseBlend;
import chap03_decorator.noSize.condiment.Mocha;
import chap03_decorator.noSize.condiment.Soy;
import chap03_decorator.noSize.condiment.Whip;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
