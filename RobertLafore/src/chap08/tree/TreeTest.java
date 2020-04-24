package chap08.tree;

public class TreeTest {
    public static void main(String[] args) {
        Node node = new Node();
        node.displayNode();
        node.iData = 1;
        node.dData = 1.1;
        node.displayNode();
        System.out.println();

        Tree tree = new Tree();
        tree.insert(16, 1.1);
        tree.insert(10, 1.1);
        tree.insert(8, 1.1);
        tree.insert(4, 1.1);
        tree.insert(2, 1.1);
        tree.insert(6, 1.1);

        tree.insert(24, 1.1);
        tree.insert(20, 1.1);
        tree.insert(18, 1.1);
        tree.insert(22, 1.1);
        tree.insert(28, 1.1);
        tree.insert(26, 1.1);
        tree.insert(30, 1.1);
        tree.displayTree();
    }
}
