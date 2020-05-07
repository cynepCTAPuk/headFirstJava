package algorithms.stepik2;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Test123a {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);
        int n = scanner.nextInt();
        int arrival, duration;
        int whenFree = -1;
        for (int i = 0; i < n; i++) {
            int start;
            arrival = scanner.nextInt();
            duration = scanner.nextInt();
            while (queue.size() > 0 && queue.peek() <= arrival) {
                queue.take();
            }

            start = Integer.max(arrival, whenFree);

            if (queue.size() == size) {
                System.out.print(-1 + " ");
                continue;
            }
            whenFree = start + duration;
            queue.add(whenFree);
            System.out.print(start + " ");
        }
    }
}