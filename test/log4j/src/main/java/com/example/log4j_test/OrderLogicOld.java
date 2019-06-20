package com.example.log4j_test;
/*
https://devcolibri.com/учимся-ввести-логирования-с-помощью-log4j/
 */
public class OrderLogicOld {

    public void doOrder(){
        // какае-то логика
        System.out.println("Заказ оформлен!");
        addToCart();
    }

    private void addToCart() {
        // добавление товара в корзину
        System.out.println("Товар добавлен в корзину");
    }

}