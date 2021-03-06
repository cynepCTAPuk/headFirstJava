package chap04_1_factory_method.simple_pizza_factory;

public class PizzaStore {
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        new PizzaStore(
                new SimplePizzaFactory())
                .orderPizza("pepperoni");
    }

    Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
