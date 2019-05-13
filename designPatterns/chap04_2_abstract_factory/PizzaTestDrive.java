package chap04_2_abstract_factory;

import chap04_2_abstract_factory.california.CaliforniaStylePizzaStore;
import chap04_2_abstract_factory.chicago.ChicagoStylePizzaStore;
import chap04_2_abstract_factory.ny.NYStylePizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicageStore = new ChicagoStylePizzaStore();
        PizzaStore californiaStore = new CaliforniaStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicageStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = californiaStore.orderPizza("cheese");
        System.out.println("John ordered a " + pizza.getName() + "\n");
    }
}
