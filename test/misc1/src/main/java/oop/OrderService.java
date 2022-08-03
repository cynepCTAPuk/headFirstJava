package oop;

import java.time.LocalDate;

public interface OrderService {
    Order[] getOrderByClient(long clientID);

    default Order[] getOrderByClient(long clientID, LocalDate date) {
        Order[] allOrders = getOrderByClient(clientID);
        return Orders.filterByDate(allOrders, date);

    }
}
