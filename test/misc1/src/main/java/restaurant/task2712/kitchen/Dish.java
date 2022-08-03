package restaurant.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);
    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public static String allDishesToString() {
//        StringJoiner joiner = new StringJoiner(", ");
//        for (Dish dish : Dish.values()) joiner.add(dish.toString());
//        return joiner.toString();
        return Arrays.toString(values());
    }

    public static void main(String[] args) {
        System.out.println(Dish.allDishesToString());
    }
}
