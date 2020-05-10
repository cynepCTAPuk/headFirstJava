package algorithms.stepik2;

import util.Util;

import java.util.*;

/**
 * Stepik Algorithm2: Объединение таблиц<p>
 * Реализовать симуляцию объединения таблиц в базе данных.<p>
 * Вход: Первая строка содержит числа n и m - число таблиц и число запросов, соответственно.
 * Вторая строка содержит n целых чисел r<sub>1</sub>, ..., r<sub>n</sub> - размеры таблиц.
 * Каждая из последующих m строк содержит два номера таблиц destination<sub>i</sub> и
 * source<sub>i</sub>, которые необходимо объединить.<p>
 * Выход: Для каждого из m запросов выведите максимальный размер таблицы после соответствующего
 * объединения.
 * Ограничения:
 * 1 <= n, m <= 100_000; 1 <= r<sub>i</sub> <= 10_000;
 * 1 <= destination<sub>i</sub>, source<sub>i</sub> <= n<p>
 * Пример.<p>
 * Вход:<p>
 * 5 5<p>
 * 1 1 1 1 1<p>
 * 3 5<p>
 * 2 4<p>
 * 1 4<p>
 * 5 4<p>
 * 5 3<p>
 * Выход:<p>
 * 2<p>
 * 2<p>
 * 3<p>
 * 5<p>
 * 5
 */
public class Test233 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // qty tables
        int m = scanner.nextInt();  // qty queries
        int[] parent = new int[n];
        int[] sizes = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            if (size > max) max = size;
            parent[i] = i;
            sizes[i] = size;
        }
        int[] destinations = new int[m];
        int[] sources = new int[m];
        for (int i = 0; i < m; i++) {
            destinations[i] = scanner.nextInt() - 1;
            sources[i] = scanner.nextInt() - 1;
        }
//        Util.printArray(parent, "parent");
//        Util.printArray(sizes, "size");
        for (int i = 0; i < m; i++) {
            int destination = destinations[i];
            int source = sources[i];
//            System.out.println(destination + ":" + source);
            source = parent(source, parent);
            destination = parent(destination, parent);

            if (source != destination) {
                parent[source] = destination;
                int size = sizes[destination] + sizes[source];
                if (size > max) max = size;
                sizes[destination] = size;
            }
//            Util.printArray(parent, "parent");
//            Util.printArray(sizes, "size");
            System.out.println(max);
        }
    }

    private static int parent(int i, int[] array) {
        if (i != array[i]) array[i] = parent(array[i], array);
        return array[i];
    }
}
