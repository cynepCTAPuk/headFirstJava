package restaurant.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
//        StringJoiner joiner = new StringJoiner(", ");
//        for (Dish dish : Dish.values()) joiner.add(dish.toString());
//        return joiner.toString();
        return Arrays.toString(values());
    }

    public static void main(String[] args) {
        System.out.println(allDishesToString());
    }
}
