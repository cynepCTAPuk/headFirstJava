package chap09_iterator.old;

import chap09_iterator.MenuItem;

import java.util.ArrayList;

public class WaiterForEach {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    void printMenu() {
        printBreakfastMenu();
        printLunchMenu();
    }

    void printBreakfastMenu() {
        for (MenuItem menuItem:breakfastItems) {
            System.out.print("\n" + menuItem.getName() + " " +
                    menuItem.getPrice() + " " + menuItem.getDescription());
        }
    }

    void printLunchMenu() {
        for (MenuItem menuItem:lunchItems) {
            if (menuItem != null) {
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
        WaiterForEach waiter = new WaiterForEach();
        waiter.printBreakfastMenu();
        waiter.printLunchMenu();
    }
}
