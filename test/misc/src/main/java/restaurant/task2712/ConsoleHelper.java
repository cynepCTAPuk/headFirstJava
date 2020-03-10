package restaurant.task2712;

import restaurant.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        while (true) {
            writeMessage("Выберите блюдо из нашего меню:");
            writeMessage(Dish.allDishesToString());
            writeMessage("Для выхода из выбора блюд наберите exit");
            String string = readString();
            if (string.toLowerCase().equals("exit")) break;
            try {
                dishes.add(Dish.valueOf(string));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда в меню нет!");
            }
        }
        return dishes;
    }
}
