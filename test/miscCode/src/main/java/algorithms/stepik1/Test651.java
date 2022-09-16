package algorithms.stepik1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stepic: точки и отрезки
 * В первой строке задано два целых числа 1 ≤ n ≤ 50000 и 1 ≤ m ≤ 50000 — количество отрезков и
 * точек на прямой, соответственно. Следующие n строк содержат по два целых
 * числа a<sub>i</sub> и b<sub>i</sub> (a<sub>i</sub> ≤ b<sub>i</sub>) — координаты концов отрезков.
 * Последняя строка содержит m целых чисел — координаты точек. Все координаты
 * не превышают 10<sup>8</sup> по модулю. Точка считается принадлежащей отрезку, если она
 * находится внутри него или на границе. Для каждой точки в порядке появления во вводе
 * выведите, скольким отрезкам она принадлежит.<p>
 * Sample Input:<p>
 * 2 3<p>
 * 0 5<p>
 * 7 10<p>
 * 1 6 11<p>
 * Sample Output:<p>
 * 1 0 0
 */
public class Test651 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dotList.add(new Dot(scanner.nextInt(), -1, -1));
            dotList.add(new Dot(scanner.nextInt(), 1, -1));
        }
        for (int i = 0; i < m; i++) {
            dotList.add(new Dot(scanner.nextInt(), 0, i));
        }
        dotList.sort((o1, o2) -> {
            int i = o1.x - o2.x;
            if (i == 0) return o1.type - o2.type;
            return i;
        });
        int count = 0;
        int[] dots = new int[m];
        for (Dot d : dotList) {
            if (d.type == -1) count++;
            else if (d.type == 1) count--;
            else if (d.type == 0) dots[d.order] = count;
        }
        for (int i : dots) System.out.print(i + " ");
    }

    static void printArray(int[] array) {
        System.out.print("[");
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) System.out.print(array[i] + " ");
            else System.out.println(array[i] + "]");
        }
    }


    private static class Dot {
        int x;
        int type;
        int order;

        public Dot(int x, int type, int order) {
            this.x = x;
            this.type = type;
            this.order = order;
        }

        @Override
        public String toString() {
            return "{" + "x=" + x + ", type=" + type + ", order=" + order + '}';
        }
    }
}
