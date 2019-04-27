package chap04_factory.pizza_factory_method.california;

import chap04_factory.pizza_factory_method.Pizza;

public class CaliforniaStyleCheesePizza extends Pizza {
    public CaliforniaStyleCheesePizza() {
        name = "California Style Cheese Pizza";
        dough = "Ah Crust Dough";
        sauce = "Oh Sauce";

        toppings.add("California Cheese");
    }
}
