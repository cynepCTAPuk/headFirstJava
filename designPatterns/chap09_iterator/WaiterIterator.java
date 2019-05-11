package chap09_iterator;

import java.util.Iterator;

public class WaiterIterator {
    PancakeHouseMenuWithIterator pancakeHouseMenu;
    DinerMenuWithIterator dinerMenu;
    Iterator pancakeHouseMenuIterator;
    Iterator dinerMenuIterator;

    public WaiterIterator(
            PancakeHouseMenuWithIterator pancakeHouseMenu, DinerMenuWithIterator dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        dinerMenuIterator = dinerMenu.createIterator();
    }

    void printMenu() {
        System.out.println("MENU\n---\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", " +
                    menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }

    void printBreakfastMenu() {
        System.out.println("MENU\n---\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);
    }

    void printLunchMenu() {
        System.out.println("MENU\n---\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    void printVegetarianMenu() {
    }

    void isItemVegetarian() {
    }

    public static void main(String[] args) {
        PancakeHouseMenuWithIterator pancakeHouseMenu = new PancakeHouseMenuWithIterator();
        DinerMenuWithIterator dinerMenu = new DinerMenuWithIterator();
        WaiterIterator waiter = new WaiterIterator(pancakeHouseMenu, dinerMenu);
        waiter.printMenu();
    }
}
