package chap04_factory.pizza_factory;

public class CaliforniaStyleCheesePizza extends Pizza {
    public CaliforniaStyleCheesePizza() {
        name = "California Style Cheese Pizza";
        dough = "Ah Crust Dough";
        sauce = "Oh Sauce";

        toppings.add("California Cheese");
    }
}
