package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Проверка свойства дерева поиска<p>
 * Проверить, является ли данное дерево деревом поиска.<p>
 * <p>
 * Вход: Двоичное дерево.
 * Первая строка содержит число вершин n. Вершины дерева пронумерованы числами от 0 до n-1.
 * Вершина 0 является корнем. Каждая из следующих n строк содержит информацию о вершинах:
 * i-я строка задаёт числа key<sub>i</sub>, left<sub>i</sub>, и right<sub>i</sub>, где
 * key<sub>i</sub> - ключ вершины i, left<sub>i</sub> - индекс левого сыны вершины i,
 * а right<sub>i</sub> - индекс правого сына вершины i. -1 - нет сына.<p>
 * <p>
 * Выход: Проверить, является ли данное дерево корректным деревом поиска:
 * верно ли, что для любой вершины дерева её ключ больше всех ключе в левом поддереве
 * и меньше всех ключей в правом поддереве
 * Выведите "CORRECT" или "INCORRECT".<p>
 * Ограничения:
 * .<p>
 * Пример.<p>
 * Вход:<p>
 * 3<p>
 * 2 1 3<p>
 * 1 -1 -1<p>
 * 3 -1 -2<p>
 * Выход:<p>
 * CORRECT<p>
 * "abcdefghijklmnoprqstuwxyz"
 */
public class Test442a {
    private static int[] key;
    private static int[] left;
    private static int[] right;
    private static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        key = new int[n];
        left = new int[n];
        right = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = input.readLine().split(" ");
            key[i] = Integer.parseInt(s[0]);
            left[i] = Integer.parseInt(s[1]);
            right[i] = Integer.parseInt(s[2]);
        }
        if (n > 0)
            in_order(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result ? "CORRECT" : "INCORRECT");
    }

    private static void in_order(int i, int min, int max) {
        if (left[i] > -1)
            in_order(left[i], min, key[i]);
        if (key[i] <= min || key[i] >= max)
            result = false;
        if (right[i] > -1)
            in_order(right[i], key[i], max);
    }
}