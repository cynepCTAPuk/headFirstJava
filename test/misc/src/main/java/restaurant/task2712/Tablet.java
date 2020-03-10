package restaurant.task2712;

import restaurant.task2712.ad.AdvertisementManager;
import restaurant.task2712.ad.NoVideoAvailableException;
import restaurant.task2712.kitchen.Order;
import restaurant.task2712.kitchen.TestOrder;
import restaurant.task2712.statistic.StatisticManager;
import restaurant.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            return getOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return null;
    }

    public void createTestOrder() {
        try {
            Order order = new TestOrder(this);
            getOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private Order getOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        try {
            if (!order.isEmpty()) {
                queue.add(order);
                AdvertisementManager adManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                logger.log(Level.INFO, "видео выбрано");
                adManager.processVideos();
            }
        } catch (NoVideoAvailableException e) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(
                    order.getTotalCookingTime() * 60));
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }


    @Override
    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}
