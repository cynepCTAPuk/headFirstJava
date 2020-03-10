package restaurant.task2712;

import restaurant.task2712.kitchen.Cook;
import restaurant.task2712.kitchen.Order;
import restaurant.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 200;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("CTAPuk");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(orderQueue);
        }

        Thread threadCook1 = new Thread(cook1);
        Thread threadCook2 = new Thread(cook2);
        threadCook1.start();
        threadCook2.start();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        Thread.sleep(1_000);
        thread.interrupt();
        threadCook1.interrupt();
        threadCook2.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
