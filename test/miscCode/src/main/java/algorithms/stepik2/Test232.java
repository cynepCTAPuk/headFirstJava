package algorithms.stepik2;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Параллельная обработка<p>
 * По данным n процессорам и m задач определите, для каждой из задач,
 * каким процессором она будет обработана.<p>
 * Вход: Число процессоров n и последовательность чисел t<sub>0</sub>, ..., t<sub>m-1</sub>,
 * где t<sub>i</sub> - время, необходимое на обработку i-й задачи. Первая строка входа
 * содержит числа n и m. Вторая содержит числа - время.<p>
 * Выход: Для каждой задачи определите, какой процессор и в какое время начнёт её обрабатывать,
 * предполагая, что каждая задача поступает на обработку первому освободившемуся процессору.
 * Выход должен содержать ровно m строк: i-я (считая с нуля) строка должна содержать номер
 * процессора, который получит i-ю задачу на обработку и время, когда это произойдёт.<p>
 * Ограничения:
 * 1 <= n <= 10<sup>5</sup>; 1 <= m <= 10<sup>5</sup>; 0 <= t<sub>i</sub> <= 10<sup>9</sup><p>
 * Пример.<p>
 * Вход:<p>
 * 2 5<p>
 * 1 2 3 4 5<p>
 * Выход:<p>
 * 0 0<p>
 * 1 0<p>
 * 0 1<p>
 * 1 2<p>
 * 0 4
 */
public class Test232 {
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
            int time = current.time;
            System.out.println(number + " " + time);
            current.time = current.time + tasks[i];
            queue.add(current);
        }
    }

    private static class Processor implements Comparable<Processor> {
        int number;
        int time;

        public Processor(int number, int time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Processor o) {
            int result = this.time - o.time;
            return result == 0 ? this.number - o.number : result;
        }
    }
}
