package restaurant.task2712.kitchen;

import restaurant.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable table, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order);
    }

    @Override
    public String toString() {
        return name;
    }
}
