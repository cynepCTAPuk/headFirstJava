package chap04_1_factory_method.california;

import chap04_1_factory_method.Pizza;
import chap04_1_factory_method.PizzaStore;

public class CaliforniaStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) pizza = new CaliforniaStyleCheesePizza();
        else if (type.equals("greek")) pizza = new CaliforniaStyleGreekPizza();
        else if (type.equals("pepperoni")) pizza = new CaliforniaStylePepperoniPizza();
        else if (type.equals("clam")) pizza = new CaliforniaStyleClamPizza();
        else if (type.equals("veggie")) pizza = new CaliforniaStyleVeggiePizza();
        else System.out.println("Wrong name of pizza!!!");
        return pizza;
    }
}
