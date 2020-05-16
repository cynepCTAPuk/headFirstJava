package algorithms.stepik2;

import java.util.*;

/**
 * Stepik Algorithm2: Проверка более общего свойства дерева поиска<p>
 * Данная задача полностью аналогична предыдущей, но проверять теперь нужно более общее свойство. Дереву разрешается содержать
 * равные ключи, но они всегда должны находиться в правом поддереве.
 * Формально, двоичное дерево называется деревом поиска, если для
 * любой вершины её ключ больше всех ключей из её левого поддерева
 * и не меньше всех ключей из правого поддерева.<p>
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
 * <p>
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
 * "abcdefghijklmnoprqstuwxyz"  \u2260<p>
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */
public class Test443 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        int[] keys = new int[n];
        int[] lefts = new int[n];
        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scanner.nextInt();
            lefts[i] = scanner.nextInt();
            rights[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < n; i++) {
            nodes[i].key = keys[i];
            if (lefts[i] > -1) nodes[i].left = nodes[lefts[i]];
            if (rights[i] > -1) nodes[i].right = nodes[rights[i]];
        }
        System.out.println(nodes.length == 0
                                   ? "CORRECT" : isBST(nodes[0], Long.MIN_VALUE, Long.MAX_VALUE)
                                                         ? "CORRECT" : "INCORRECT");
    }

    static boolean isBST(Node node, long min, long max) {
        /* an empty tree is BST */
        if (node == null) return true;
        /* false if this node violates the min/max constraints */
//        if (node.key < min || node.key > max) return false;
        if (node.key < min || node.key >= max) return false;
        /* otherwise check the subtrees recursively tightening the min/max constraints */
        // Allow only distinct values
//        return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    private static class Node {
        int key;
        int parentKey;
        Node left;
        Node right;

        @Override
        public String toString() {
            return key + ":" + parentKey;
        }
    }
}