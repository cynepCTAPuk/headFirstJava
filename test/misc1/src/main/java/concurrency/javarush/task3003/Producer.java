package concurrency.javarush.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
//            while (!Thread.interrupted()) {
            for (int i = 1; i <= 9; i++) {
                System.out.format("Элемент 'ShareItem- %d'добавлен%n", i);
                queue.offer(new ShareItem("ShareItem-N", i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer())
                    System.out.format("Consumer в ожидании!%n");
            }
//            }
        } catch (InterruptedException ignored) {
        }
    }
}
