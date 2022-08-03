package concurrency.other;

import java.util.Date;

/**
 * https://www.youtube.com/watch?time_continue=12&v=SNgipZ8oOK4&feature=emb_logo
 * Многопоточность в Java. Базовые примитивы синхронизации
 * Проходил 21 июня 2018 года
 * Преподаватель: Сергей Петрелевич
 */
public class Task {
    private Object obj = new Object();
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    private void waitTask() {
        try {
            obj.wait();
            System.out.println("OK");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new Task().waitTask();
        new Task().action1();
    }

    private void f() {
//        obj.notify();
//        obj.notifyAll();
        obj2.notifyAll();
    }

    private void action1() {
        synchronized (obj) {
            try {
                System.out.println("action1 start: " + new Date());
                obj.wait();
//                obj.wait(10_000);
                System.out.println("action1 finish: " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
