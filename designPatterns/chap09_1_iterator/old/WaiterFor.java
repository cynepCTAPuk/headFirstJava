package chap09_1_iterator.old;

import chap09_1_iterator.MenuItem;

import java.util.ArrayList;

public class WaiterFor {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    void printMenu() {
        printBreakfastMenu();
        printLunchMenu();
    }

    void printBreakfastMenu() {
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = breakfastItems.get(i);
            System.out.print("\n" + menuItem.getName() + " " +
                    menuItem.getPrice() + " " + menuItem.getDescription());
        }
    }

    void printLunchMenu() {
        for (int i = 0; i < lunchItems.length; i++) {
            if (lunchItems[i] != null) {
                MenuItem menuItem = lunchItems[i];
                System.out.print("\n" + menuItem.getName() + " " +
                        menuItem.getPrice() + " " + menuItem.getDescription());
            } else return;
        }
    }

    void printVegetarianMenu() {
    }

    void isItemVegetarian() {
    }

    public static void main(String[] args) {
        WaiterFor waiter = new WaiterFor();
        waiter.printBreakfastMenu();
        waiter.printLunchMenu();
    }
}
