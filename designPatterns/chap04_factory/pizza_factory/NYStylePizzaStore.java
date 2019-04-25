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

    public class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "NY Style Sauce and Cheese Pizza";
            dough = "Thin Crust Dough";
            sauce = "Marinara Sauce";
        }
    }

    public class NYStyleGreekPizza extends Pizza {
    }

    public class NYStylePepperoniPizza extends Pizza {
    }

    public class NYStyleClamPizza extends Pizza {
    }

    public class NYStyleVeggiePizza extends Pizza {
    }
}
