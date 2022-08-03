package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Stepik Algorithm2: Максимум в скользящем окне
 */
public class Test125 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");
        int m = Integer.parseInt(reader.readLine());

        ArrayDeque<Pair> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Pair current = new Pair(Integer.parseInt(numbers[i]));
            while (!deque.isEmpty() && current.value > deque.peekLast().value)
                current.count += deque.removeLast().count;
            deque.addLast(current);
            if (i + 1 >= m) {
                System.out.print(deque.peekFirst().value + " ");
                deque.peekFirst().count--;
                if (deque.peekFirst().count == 0) deque.removeFirst();
            }
        }
    }

    private static class Pair {
        private int value;
        private int count = 1;

        public Pair(int value) {
            this.value = value;
        }
    }
}
