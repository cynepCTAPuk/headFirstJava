// https://www.youtube.com/watch?v=BmBr5diz8WA Евгений Борисов — Spring-потрошитель, часть 1
package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
/*
        while (true) {
            Thread.sleep(1_000);
            context.getBean(Quoter.class).sayQuote();
        }
*/
//        context.getBean(Quoter.class).sayQuote();

    }
}
