package restaurant.task2712;

import restaurant.task2712.kitchen.Cook;
import restaurant.task2712.kitchen.Order;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        tablet.addObserver(new Cook("Amigo"));
        Order order = tablet.createOrder();

    }
}
