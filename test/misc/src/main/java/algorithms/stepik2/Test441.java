package algorithms.stepik2;

import algorithms.AVLTreeTest;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Обход дерева<p>
 * Построить in-order, pre-order и post-order обход данного двоичного дерева.<p>
 * in-order - рекурсивный вызов для v.left, напечатать v.key, рекурсивный вызов для v.right<p>
 * pre-order - напечатать v.key, рекурсивный вызов для v.left, рекурсивный вызов для v.right<p>
 * post-order - рекурсивный вызов для v.left, рекурсивный вызов для v.right, напечатать v.key<p>
 * Вход: Двоичное дерево.
 * Первая строка содержит число вершин n. Вершины дерева пронумерованы числами от 0 до n-1.
 * Вершина 0 является корнем. Каждая из следующих n строк содержит информацию о вершинах:
 * i-я строка задаёт числа key<sub>i</sub>, left<sub>i</sub>, и right<sub>i</sub>, где
 * key<sub>i</sub> - ключ вершины i, left<sub>i</sub> - индекс левого сыны вершины i,
 * а right<sub>i</sub> - индекс правого сына вершины i. -1 - нет сына.<p>
 * Выход: Все его вершины в трёх разных порядках, три строки: in-order, pre-order, post-order.<p>
 * Ограничения:
 * .<p>
 * Пример.<p>
 * Вход:<p>
 * 5<p>
 * 4 1 2<p>
 * 2 3 4<p>
 * 5 -1 -2<p>
 * 1 -1 -1<p>
 * 3 -1 -2<p>
 * Выход:<p>
 * 1 2 4 4 5<p>
 * 4 2 1 3 5<p>
 * 1 3 2 5 4<p>
 * "abcdefghijklmnoprqstuwxyz"
 */
public class Test441 {
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

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            nodes[i].key = key[i];
            if (left[i] > -1) nodes[i].left = nodes[left[i]];
            if (right[i] > -1) nodes[i].right = nodes[right[i]];
        }

        Node.inOrder(nodes[0]);
        System.out.println();
        Node.preOrder(nodes[0]);
        System.out.println();
        Node.postOrder(nodes[0]);
    }

    private static class Node {
        int key;
        Node left, right;

        static void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.printf("%d ", node.key);
                inOrder(node.right);
            }
        }

        static void preOrder(Node node) {
            if (node != null) {
                System.out.printf("%d ", node.key);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        static void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.printf("%d ", node.key);
            }
        }
    }
}