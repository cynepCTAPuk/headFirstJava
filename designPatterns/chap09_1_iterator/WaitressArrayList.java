package chap09_1_iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class WaitressArrayList {
    ArrayList<Menu> menus;

    public WaitressArrayList(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", " +
                    menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }

    public void printMenu() {
        Iterator<Menu> menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    public void printBreakfastMenu() {
    }

    public void printLunchMenu() {
    }

    public void printVegetarianMenu() {
    }

    public boolean isItemVegetarian(MenuItem menuItem) {
        return menuItem.isVegetarian();
    }

    public static void main(String[] args) {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new PancakeHouseMenu());
        menus.add(new DinerMenu());
        menus.add(new CafeMenu());
        WaitressArrayList waiter = new WaitressArrayList(menus);
        waiter.printMenu();
    }
}
