package chap04_factory.pizza_abstract_factory.Chicago;

import chap04_factory.pizza_abstract_factory.*;

public class ChigagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {
                new BlackOlives(), new Spinach(),
                new EggPlant()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }

    private class ThickCrustDough extends Dough {
    }

    private class PlumTomatoSauce extends Sauce {
    }

    private class MozzarellaCheese extends Cheese {
    }

    private class BlackOlives extends Veggies {
    }

    private class Spinach extends Veggies {
    }

    private class EggPlant extends Veggies {
    }

    private class SlicedPepperoni extends Pepperoni {
    }

    private class FrozenClams extends Clams {
    }
}
