package algorithms.stepik2;

import java.util.ArrayList;
import java.util.List;

/**
 * Stepik Algorithm2: 122 Вычислить высотy дерева<p>
 * Вход: Корневое дерево с вершинами {0, ... n-1}, 1 <= n <= 10<sup>5</sup>, заданное как
 * последовательность parent<sub>0</sub>, ..., parent<sub>n-1</sub>,
 * где parent<sub>i</sub> - родитель i-й вершины.<p>
 * Выход: Высота дерева<p>
 * Sample Input:<p>
 * 10<p>
 * 9 7 5 5 2 9 9 9 2 -1<p>
 * Sample Output:<p>
 * 4
 */
public class Test122 {
    public static void main(String[] args) {
        int[] ints = {4, -1, 4, 1, 1};
//        int[] ints = {-1, 0, 4, 0, 3};
        Node[] nodes = new Node[ints.length];
        for (int i = 0; i < ints.length; i++) nodes[i] = new Node(i);

        Node root = nodes[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == -1) root = nodes[i];
            else nodes[ints[i]].children.add(nodes[i]);
        }

        System.out.println(height(root));
    }

    private static int height(Node node) {
        int height = 1;
        for (Node child : node.children) height = Math.max(height, 1 + height(child));
        return height;
    }

    private static void printTree(Node node) {
        System.out.println(node.data);
        for (Node child : node.children) printTree(child);
    }

    private static class Node {
        int data;
        List<Node> children = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                           "data=" + data +
                           ", children=" + children +
                           '}';
        }
    }
}
