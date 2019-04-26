package chap04_factory.pizza_abstract_factory.NY;

import chap04_factory.pizza_abstract_factory.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(),
                new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }

    private class ThickCrustDough extends Dough {
    }

    private class MarinaraSauce extends Sauce {
    }

    private class ReggianoCheese extends Cheese {
    }

    private class Garlic extends Veggies {
    }

    private class Onion extends Veggies {
    }

    private class Mushroom extends Veggies {
    }

    private class RedPepper extends Veggies {
    }

    private class FreshClams extends Clams {
    }
}
