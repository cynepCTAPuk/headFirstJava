package chap04_1_factory_method.simple_pizza_factory;

public class SimplePizzaFactory {
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) pizza = new CheesePizza();
        else if (type.equals("greek")) pizza = new GreekPizza();
        else if (type.equals("pepperoni")) pizza = new PepperoniPizza();
        else if (type.equals("clam")) pizza = new ClamPizza();
        else if (type.equals("veggie")) pizza = new VeggiePizza();
        else System.out.println("Wrong name of pizza!!!");
        return pizza;
    }
}
