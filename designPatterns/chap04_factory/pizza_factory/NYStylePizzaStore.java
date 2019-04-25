package chap04_factory.pizza_factory;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) pizza = new NYStyleCheesePizza();
        else if (type.equals("greek")) pizza = new NYStyleGreekPizza();
        else if (type.equals("pepperoni")) pizza = new NYStylePepperoniPizza();
        else if (type.equals("clam")) pizza = new NYStyleClamPizza();
        else if (type.equals("veggie")) pizza = new NYStyleVeggiePizza();
        else System.out.println("Wrong name of pizza!!!");
        return pizza;
    }
}
