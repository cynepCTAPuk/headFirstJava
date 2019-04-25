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

    public class ChicagoStyleCheesePizza extends Pizza {
        public ChicagoStyleCheesePizza() {
            name = "Chicago Style Deep Dish Cheese Pizza";
            dough = "Extra Thick Crust Dough";
            sauce = "Plum Tomato Sauce";

            toppings.add("Shredde Mozzarella Cheese");
        }

        @Override
        void cut() {
            System.out.println("Cutting the pizza into square slices");
        }
    }

    public class ChicagoStyleGreekPizza extends Pizza {
    }

    public class ChicagoStylePepperoniPizza extends Pizza {
    }

    public class ChicagoStyleClamPizza extends Pizza {
    }

    public class ChicagoStyleVeggiePizza extends Pizza {
    }
}
