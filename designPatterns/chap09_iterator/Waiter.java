package chap09_iterator;

import java.util.ArrayList;
import java.util.Arrays;

public class Waiter {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    void printMenu() {
    }

    void printBreakfastMenu() {
//        System.out.println(breakfastItems);
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }

    void printLunchMenu() {
//        System.out.println(Arrays.toString(lunchItems));
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }

    void printVegetarianMenu() {
    }

    void isItemVegetarian() {
    }

    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        waiter.printBreakfastMenu();
        waiter.printLunchMenu();
    }
}
