package chap09_1_iterator.it;

import chap09_1_iterator.MenuItem;

import java.util.Iterator;

public class Waiter {
    private PancakeHouseMenu pancakeHouseMenu;
    private DinerMenu dinerMenu;

    public Waiter(
            PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", " +
                    menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }

    public void printMenu() {
        Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("MENU\n---\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    public void printBreakfastMenu() {
        Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        System.out.println("MENU\n---\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);
    }

    public void printLunchMenu() {
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("MENU\n---\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    public void printVegetarianMenu() {
    }

    public boolean isItemVegetarian(MenuItem menuItem) {
        return menuItem.isVegetarian();
    }

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waiter waiter = new Waiter(pancakeHouseMenu, dinerMenu);
        waiter.printMenu();
//        waiter.printBreakfastMenu();
//        waiter.printLunchMenu();
    }
}
