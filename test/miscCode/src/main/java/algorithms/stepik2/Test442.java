package algorithms.stepik2;

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
public class Test442 {
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