package chap04_2_abstract_factory.california;

import chap04_2_abstract_factory.*;

public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory {
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

    private class ThickCrustDough implements Dough {
    }

    private class PlumTomatoSauce implements Sauce {
    }

    private class MozzarellaCheese implements Cheese {
    }

    private class BlackOlives implements Veggies {
    }

    private class Spinach implements Veggies {
    }

    private class EggPlant implements Veggies {
    }

    private class SlicedPepperoni implements Pepperoni {
    }

    private class FrozenClams implements Clams {
    }
}
