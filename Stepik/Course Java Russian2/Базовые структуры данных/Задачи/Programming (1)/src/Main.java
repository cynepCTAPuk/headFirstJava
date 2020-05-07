import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        Node[] nodes = new Node[ints.length];
        for (int i = 0; i < ints.length; i++) {
            nodes[i] = new Node(i);
        }

        Node root = nodes[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == -1) {
                root = nodes[i];
            } else {
                nodes[ints[i]].children.add(nodes[i]);
            }
        }

        System.out.println(height(root));
    }

    private static int height(Node node) {
        int height = 1;
        for (Node child : node.children) {
            height = Math.max(height, 1 + height(child));
        }
        return height;
    }

    private static class Node {
        int data;
        List<Node> children = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }
    }
}
