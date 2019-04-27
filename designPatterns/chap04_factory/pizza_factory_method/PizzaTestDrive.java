package chap04_factory.pizza_factory_method;

import chap04_factory.pizza_factory_method.california.CaliforniaStylePizzaStore;
import chap04_factory.pizza_factory_method.chicago.ChicagoStylePizzaStore;
import chap04_factory.pizza_factory_method.ny.NYStylePizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        PizzaStore californiaStore = new CaliforniaStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = californiaStore.orderPizza("cheese");
        System.out.println("John ordered a " + pizza.getName() + "\n");
    }
}
