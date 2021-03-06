import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = reader.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(strings[i]);
        int m = Integer.parseInt(reader.readLine());

        Deque<Pair> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Pair current = new Pair(numbers[i]);
            while (!deque.isEmpty() && current.value > deque.peekLast().value) {
                current.count += deque.removeLast().count;
            }
            deque.addLast(current);
            if (i + 1 >= m) {
                System.out.print(deque.peekFirst().value + " ");
                deque.peekFirst().count--;
                if (deque.peekFirst().count == 0) {
                    deque.removeFirst();
                }
            }
        }
    }

    public static class Pair {
        int value;
        int count = 1;

        public Pair(int value) {
            this.value = value;
        }
    }
}
