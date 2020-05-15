package algorithms.stepik2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Проверка более общего свойства дерева поиска<p>
 * Данная задача полностью аналогична предыдущей, но проверять теперь нужно более общее свойство. Дереву разрешается содержать
 * равные ключи, но они всегда должны находиться в правом поддереве.
 * Формально, двоичное дерево называется деревом поиска, если для
 * любой вершины её ключ больше всех ключей из её левого поддерева
 * и не меньше всех ключей из правого поддерева.<p>
 *
 * Вход: Двоичное дерево.
 * Первая строка содержит число вершин n. Вершины дерева пронумерованы числами от 0 до n-1.
 * Вершина 0 является корнем. Каждая из следующих n строк содержит информацию о вершинах:
 * i-я строка задаёт числа key<sub>i</sub>, left<sub>i</sub>, и right<sub>i</sub>, где
 * key<sub>i</sub> - ключ вершины i, left<sub>i</sub> - индекс левого сыны вершины i,
 * а right<sub>i</sub> - индекс правого сына вершины i. -1 - нет сына.<p>
 *
 * Выход: Проверить, является ли данное дерево корректным деревом поиска:
 * верно ли, что для любой вершины дерева её ключ больше всех ключе в левом поддереве
 * и меньше всех ключей в правом поддереве
 * Выведите "CORRECT" или "INCORRECT".<p>
 *
 * Ограничения: 0 ≤ n ≤ 10<sup>5</sup>; −2<sup>31</sup> ≤ key<sub>i</sub> ≤ 2<sup>31</sup>−1
 * (таким образом, в качестве ключей допустимы минимальное и максимальное значение 32-битного
 * целого типа, будьте осторожны с переполнением); −1 ≤ left<sub>i</sub>, right<sub>i</sub> ≤ n − 1.
 * Гарантируется, что вход задаёт корректное двоичное дерево: в частности,
 * если left<sub>i</sub> ≠ −1 и right<sub>i</sub> ≠ −1, то left<sub>i</sub> ≠ right<sub>i</sub>;
 * никакая вершина не является сыном двух вершин; каждая вершина является потомком корня.<p>
 * Пример.<p>
 * Вход:<p>
 * 3<p>
 * 2 1 3<p>
 * 1 -1 -1<p>
 * 3 -1 -2<p>
 * Выход:<p>
 * CORRECT<p>
 * "abcdefghijklmnoprqstuwxyz"  \u2260
 */
public class Test443 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        int[] key = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = scanner.nextInt();
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < n; i++) {
            nodes[i].key = key[i];
            if (left[i] > -1) nodes[i].left = nodes[left[i]];
            if (right[i] > -1) nodes[i].right = nodes[right[i]];
        }

        List<Integer> arrayList = new ArrayList<>();
        if (n > 0) Node.inOrderTree(nodes[0], arrayList);
        System.out.println(arrayList);
        System.out.println(isSortedList(arrayList) ? "CORRECT" : "INCORRECT");
    }

    public static boolean isSortedList(List<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++)
            if (arrayList.get(i - 1) > arrayList.get(i))
                return false;
        return true;
    }

    private static class Node {
        int key;
        Node left, right;

        static void inOrderTree(Node node, List<Integer> list) {
            if (node != null) {
                inOrderTree(node.left, list);
                list.add(node.key);
                inOrderTree(node.right, list);
            }
        }
    }
}