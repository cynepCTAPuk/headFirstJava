package algorithms.stepik2;

import java.util.LinkedList;
import java.util.Scanner;

public class Test123b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();

        LinkedList<Integer> buffer = new LinkedList<>();

        int last = 0;
        for (int i = 0; i < n; i++) {
            int arrival = sc.nextInt();
            int duration = sc.nextInt();

            while (!buffer.isEmpty() && buffer.peek() <= arrival) {
                buffer.poll();
            }

            if (buffer.size() < size) {
                int start = Math.max(arrival, last);
                last = start + duration;
                buffer.offer(last);
                System.out.println(start);
            } else {
                System.out.println(-1);
            }
        }
    }
}