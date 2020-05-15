import java.util.Scanner;

class Main {
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