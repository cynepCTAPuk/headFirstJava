/*
 https://javarush.ru/groups/posts/2111-threadom-java-ne-isportishjh--chastjh-vi---k-barjheru
 Thread'ом Java не испортишь: Часть VI — К барьеру!
 */

import java.util.concurrent.Phaser;

public class Thread67 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        // Вызывая метод register, мы регистрируем текущий поток (main) как участника
//        phaser.register();
        System.out.println("Phasecount is " + phaser.getPhase());
        testPhaser(phaser);
        testPhaser(phaser);
        testPhaser(phaser);
        // Через 3 секунды прибываем к барьеру и снимаемся регистрацию.
        // Кол-во прибывших = кол-во регистраций = пуск
        Thread.sleep(3_000);
        phaser.arriveAndDeregister();
        System.out.println("Phasecount is " + phaser.getPhase());
    }

    private static void testPhaser(final Phaser phaser) {
        // Говорим, что будет +1 участник на Phaser
        phaser.register();
        // Запускаем новый поток
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " arrived");
            phaser.arriveAndAwaitAdvance(); //threads register arrival to the phaser.
            System.out.println(name + " after passing barrier");
        }).start();
    }
}
