package algorithms;

public class Tree {
    public static void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.left = three;
        one.right = four;
        four.left = zero;
        four.right = two;

/*
        zero.left = one;
        zero.right = three;
        three.right = four;
        four.right = two;
*/

        printTree(one);
        System.out.println(height(one));
    }

    private static int height(Node node) {
        int height = 1;
        if (node.left != null) height = Math.max(height, 1 + height(node.left));
        if (node.right != null) height = Math.max(height, 1 + height(node.right));
        return height;
    }

    private static void printTree(Node node) {
        System.out.println(node.data);
        if (node.left != null) printTree(node.left);
        if (node.right != null) printTree(node.right);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
