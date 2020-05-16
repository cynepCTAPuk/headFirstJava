import java.util.Scanner;

class Main {
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
        if (nodes.length == 0)
            System.out.println("CORRECT");
        else
            System.out.println(isBST(nodes[0], Long.MIN_VALUE, Long.MAX_VALUE) ? "CORRECT" : "INCORRECT");
    }

    static boolean isBST(Node node, long min, long max) {
        if (node == null) return true;
        if (node.key < min || node.key >= max) return false;
        return (isBST(node.left, min, node.key) && isBST(node.right, node.key, max));
    }

    private static class Node {
        int key;
        Node left;
        Node right;
    }
}