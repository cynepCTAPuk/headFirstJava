package com.example.log4j_test;

import org.apache.log4j.Logger;

/*
https://devcolibri.com/учимся-ввести-логирования-с-помощью-log4j/
 */
public class OrderLogic {
    // Инициализация логера
    private static final Logger log = Logger.getLogger(OrderLogic.class);

    public void doOrder(){
        // какае-то логика
        System.out.println("Заказ оформлен!");
        // логируем инфо
        log.info("Это информационное сообщение!");
        addToCart();
    }

    private void addToCart() {
        // добавление товара в корзину
        System.out.println("Товар добавлен в корзину");

        // логируем ошибку
        log.error("Error message");
        log.fatal("Fatal Message");
        log.warn("Warn Message");

        System.out.println();
    }

}