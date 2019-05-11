package chap09_iterator;

import java.util.Iterator;

public class Waitress {
    private Menu pancakeHouseMenu;
    private Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
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
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        System.out.println("MENU\n---\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
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
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu dinerMenu = new DinerMenu();
        Waitress waiter = new Waitress(pancakeHouseMenu, dinerMenu);
        waiter.printMenu();
    }
}
