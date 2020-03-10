package restaurant.task2712.kitchen;

import restaurant.task2712.ConsoleHelper;
import restaurant.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish : dishes) result += dish.getDuration();
        return result;
//        return dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
//        if (dishes.size() == 0) return "";
//        else return "Your order: " + Arrays.toString(dishes.toArray()) + " of " + tablet.toString();
        return dishes.isEmpty() ? "" : String.format("Your order: %s of %s", dishes, tablet);
    }
}
