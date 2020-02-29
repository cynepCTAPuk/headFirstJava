package concurrency;
/**
 * https://habr.com/ru/post/277669/
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatch_2 {
    //Создаем CountDownLatch на 8 "условий"
    private static final CountDownLatch START = new CountDownLatch(8);
    //Условная длина гоночной трассы
    private static final int trackLength = 500_000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1_000);
        }

        //Проверяем, собрались ли все автомобили у стартовой прямой. Если нет, ждем 100ms
        while (START.getCount() > 3) Thread.sleep(10);

        Thread.sleep(1_000);
        System.out.println("На старт!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1_000);
        System.out.println("Внимание!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1_000);
        System.out.println("Марш!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        //счетчик становится равным нулю, и все ожидающие потоки одновременно разблокируются
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;//считаем, что скорость автомобиля постоянная

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой. ", carNumber);
                System.out.printf("Скорость: %d км/час\n", carSpeed);
                //Автомобиль подъехал к стартовой прямой - условие выполнено уменьшаем счетчик на 1
                START.countDown();
                //метод await() блокирует поток, вызвавший его, до тех пор, пока
                //счетчик CountDownLatch не станет равен 0
                START.await();
                Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
            }
        }
    }
}