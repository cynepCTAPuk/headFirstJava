package restaurant.task2712.kitchen;

import restaurant.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        Collections.addAll(dishes, Dish.values());

        int size = Dish.values().length;
        int qty = (int) (Math.random() * size + 1);

        for (int i = 0; i < size - qty; i++)
            dishes.remove((int) (Math.random() * dishes.size()));
    }
}
