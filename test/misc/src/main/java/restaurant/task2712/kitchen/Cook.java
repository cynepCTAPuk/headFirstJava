package restaurant.task2712.kitchen;

import restaurant.task2712.ConsoleHelper;
import restaurant.task2712.statistic.StatisticManager;
import restaurant.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        String printCookingOrder = String.format(
                "Start cooking - %s, cooking time %d min", order, order.getTotalCookingTime());
        ConsoleHelper.writeMessage(printCookingOrder);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                this.name, order.getTotalCookingTime() * 60, order.getDishes()
        ));
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            while (!Thread.interrupted() && queue.peek() != null) {
                if (!isBusy()) {
                    Order order = queue.poll();
                    if (order != null) startCookingOrder(order);
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
