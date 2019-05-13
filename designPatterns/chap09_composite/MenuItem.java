package chap09_composite;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {return new NullIterator();}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getPrice() {return price;}
    public boolean isVegetarian() {return vegetarian;}

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) System.out.print("(v)");
        System.out.print(", " + getPrice());
        System.out.println(" -- " + getDescription());
    }
}