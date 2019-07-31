package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 5; i > 0; i--) q.add(i);
        while (!q.isEmpty()) System.out.print(q.poll() + " ");
        System.out.println(" Queue");

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 5; i > 0; i--) pq.add(i);
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println(" PriorityQueue");

        Queue<Integer> oepq = new PriorityQueue<>((i1, i2) -> {
            if (i1 % 2 == 0 & i2 % 2 != 0) return -1;
            if (i1 % 2 != 0 & i2 % 2 == 0) return 1;
            return i1 - i2;
        });
        for (int i = 5; i > 0; i--) oepq.add(i);
        while (!oepq.isEmpty()) System.out.print(oepq.poll() + " ");
        System.out.println(" EvenOdd PriorityQueue");
    }
}
