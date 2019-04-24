package chap04_factory.pizza_factory;

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

    private class ChicagoStyleCheesePizza extends Pizza {
    }

    private class ChicagoStyleGreekPizza extends Pizza {
    }

    private class ChicagoStylePepperoniPizza extends Pizza {
    }

    private class ChicagoStyleClamPizza extends Pizza {
    }

    private class ChicagoStyleVeggiePizza extends Pizza {
    }
}
