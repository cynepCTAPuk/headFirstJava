package chap04_1_factory_method.chicago;

import chap04_1_factory_method.Pizza;
import chap04_1_factory_method.PizzaStore;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) pizza = new ChicagoStyleCheesePizza();
        else if (type.equals("greek")) pizza = new ChicagoStyleGreekPizza();
        else if (type.equals("pepperoni")) pizza = new ChicagoStylePepperoniPizza();
        else if (type.equals("clam")) pizza = new ChicagoStyleClamPizza();
        else if (type.equals("veggie")) pizza = new ChicagoStyleVeggiePizza();
        else System.out.println("Wrong name of pizza!!!");
        return pizza;
    }
}
