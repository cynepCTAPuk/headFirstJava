package chap04_factory.pizza_abstract_factory.ny;

import chap04_factory.pizza_abstract_factory.Cheese;
import chap04_factory.pizza_abstract_factory.Clams;
import chap04_factory.pizza_abstract_factory.Dough;
import chap04_factory.pizza_abstract_factory.Pepperoni;
import chap04_factory.pizza_abstract_factory.PizzaIngredientFactory;
import chap04_factory.pizza_abstract_factory.Sauce;
import chap04_factory.pizza_abstract_factory.Veggies;
import chap04_factory.pizza_abstract_factory.california.CaliforniaPizzaIngredientFactory;

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
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }

    private class ThickCrustDough implements Dough {
    }

    private class MarinaraSauce implements Sauce {
    }

    private class ReggianoCheese implements Cheese {
    }

    private class Garlic implements Veggies {
    }

    private class Onion implements Veggies {
    }

    private class Mushroom implements Veggies {
    }

    private class RedPepper implements Veggies {
    }

    private class SlicedPepperoni implements Pepperoni {
    }

    private class FreshClams implements Clams {
    }
}
