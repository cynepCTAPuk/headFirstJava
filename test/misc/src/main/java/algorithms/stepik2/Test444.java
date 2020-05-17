package algorithms.stepik2;

import java.util.Scanner;

/**
 * <b>Stepik Algorithm2:</b> Множество с запросами суммы на отрезке<p>
 * Данная задача полностью аналогична предыдущей, но проверять теперь нужно более общее свойство.
 * Дереву разрешается содержать равные ключи, но они всегда должны находиться в правом поддереве.
 * Формально, двоичное дерево называется деревом поиска, если для любой вершины её ключ
 * больше всех ключей из её левого поддерева и не меньше всех ключей из правого поддерева.<p>
 * <b>Вход</b>: Изначально множество пусто. Первая строка содержит число запросов n.
 * Каждая из n следующих строк содержит запрос в одном из следующих четырёх форматов:<p>
 * • + i: добавить число f(i) в множество (если оно уже есть, проигнорировать запрос);<p>
 * • - i: удалить число f(i) из множества (если его нет, проигнорировать запрос);<p>
 * • ? i: проверить принадлежность числа f(i) множеству;<p>
 * • s l r: посчитать сумму всех элементов множества, попадающих в отрезок [f(l), f(r)].<p>
 * Функция f определяется следующим образом. Пусть s — результат последнего запроса суммы
 * на отрезке (если таких запросов ещё не было, то s = 0). Тогда
 * f(x) = (x + s) mod 1 000 000 001.<p>
 * <b>Выход:</b> Для каждого запроса типа ? i выведите «Found» или «Not found».
 * Для каждого запроса суммы выведите сумму всех элементов множества, попадающих в отрезок
 * [f(l), f(r)]. Гарантируется, что во всех тестах f(l) ≤ f(r).<p>
 * <b>Ограничения:</b> 1 ≤ n ≤ 10<sup>5</sup>; 0 ≤ i ≤ 10<sup>9</sup>.<p>
 * Пример.<p>
 * <b>Вход</b>:<p>
 * 15<p>
 * ? 1<p>
 * + 1<p>
 * ? 1<p>
 * + 2<p>
 * s 1 2<p>
 * + 1000000000<p>
 * ? 1000000000<p>
 * - 1000000000<p>
 * ? 1000000000<p>
 * s 999999999 1000000000<p>
 * - 2<p>
 * ? 2<p>
 * - 0<p>
 * + 9<p>
 * s 0 9<p>
 * <b>Выход</b>:<p>
 * Not found<p>
 * Found<p>
 * 3<p>
 * Found<p>
 * Not found<p>
 * 1<p>
 * Not found<p>
 * 10<p>
 */
public class Test444 {
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
        Node left;
        Node right;

        @Override
        public String toString() {
            return "" + key;
        }
    }
}