package chap04_factory;

public class PizzaCafe {
    public static void main(String[] args) {
        orderPizza();
        orderPizza("clam");
    }

    static Pizza orderPizza() {
        Pizza pizza = new Pizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    static Pizza orderPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) pizza = new CheesePizza();
        else if (type.equals("greek")) pizza = new GreekPizza();
        else if (type.equals("pepperoni")) pizza = new PepperoniPizza();
        else if (type.equals("clam")) pizza = new ClamPizza();
        else if (type.equals("veggie")) pizza = new VeggiePizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
