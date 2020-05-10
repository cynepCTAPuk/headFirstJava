import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // qty processors
        int m = scanner.nextInt();  // qty tasks
        int[] tasks = new int[m];   // task's time
        for (int i = 0; i < m; i++) {
            tasks[i] = scanner.nextInt();
        }
        PriorityQueue<Processor> queue = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            queue.add(new Processor(i, 0));
        }
        for (int i = 0; i < m; i++) {
            Processor current = queue.poll();
            int number = current.number;
            long time = current.time;
            System.out.println(number + " " + time);
            time = current.time + tasks[i];
            queue.add(new Processor(number, time));
        }
    }

    private static class Processor implements Comparable<Processor> {
        int number;
        long time;

        public Processor(int number, long time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Processor o) {
            long result = this.time - o.time;
            return result == 0 ? this.number - o.number : (int) result;
        }
    }
}
