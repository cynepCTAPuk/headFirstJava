package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
public class Test442b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tree = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                tree[i][j] = sc.nextInt();
        System.out.println(checkTree(tree) ? "CORRECT" : "INCORRECT");
    }

    private static boolean checkTree(int[][] tree) {
        if (tree.length == 0) return true;

        int current = 0;
        int previous = -1;
        LinkedList<Integer> stack = new LinkedList<>();

        while (current >= 0 || !stack.isEmpty()) {
            if (current >= 0) {
                stack.push(current);
                current = tree[current][1];
            } else {
                current = stack.pop();
                if (previous >= 0 && tree[previous][0] > tree[current][0])
                    return false;
                previous = current;
                current = tree[current][2];
            }
        }
        return true;
    }
}