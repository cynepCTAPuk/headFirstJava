package restaurant.task2712.kitchen;

import restaurant.task2712.ConsoleHelper;
import restaurant.task2712.Tablet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        else return "Your order: " + Arrays.toString(dishes.toArray()) + " of " + tablet;
    }
}
