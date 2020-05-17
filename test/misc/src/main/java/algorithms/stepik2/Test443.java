package algorithms.stepik2;

import java.util.Scanner;

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
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(n);
        SplayTree tree = new SplayTree();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            char ch = line[0].charAt(0);
            int key = Integer.parseInt(line[1]);
            System.out.println(ch + ":" + key);
            switch (ch) {
                case '+':
                    tree.root = tree.insert(tree.root, key);
                    break;
                case '-':
                    tree.root = tree.delete(tree.root, key);
                    break;
                case '?':
                    Node node = tree.find(tree.root, key);
                    System.out.println(node == null ? "Not found" : "Found");
                    break;
                case 's':
                    int key2 = Integer.parseInt(line[2]);
                    System.out.println("sum elelement between " + key + ":" + key2);
                    break;
            }
        }
    }

    private static class SplayTree {
        Node root;

        // A utility function to right rotate subtree rooted with y
        Node rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;
            return y;
        }

        // A utility function to left rotate subtree rooted with x
        Node leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            return y;
        }

        // This function brings the key at root if key is present in tree.
        // If key is not present, then it brings the last accessed item at root.
        // This function modifies the tree and returns the new root
        Node splay(Node root, int key) {
            // Base cases: root is null or key is present at root
            if (root == null || root.key == key) return root;

            if (root.key > key) { // Key lies in left subtree
                // Key is not in tree, we are done
                if (root.left == null) return root;

                // Zig-Zig (Left Left)
                if (root.left.key > key) {
                    // First recursively bring the key as root of left-left
                    root.left.left = splay(root.left.left, key);
                    // Do first rotation for root, second rotation is done after else
                    root = rightRotate(root);
                } else if (root.left.key < key) {
                    // Zig-Zag (Left Right)
                    // First recursively bring the key as root of left-right
                    root.left.right = splay(root.left.right, key);
                    // Do first rotation for root.left
                    if (root.left.right != null) root.left = leftRotate(root.left);
                }
                // Do second rotation for root
                return (root.left == null) ? root : rightRotate(root);
            } else {    // Key lies in right subtree
                // Key is not in tree, we are done
                if (root.right == null) return root;

                // Zag-Zig (Right Left)
                if (root.right.key > key) {
                    // Bring the key as root of right-left
                    root.right.left = splay(root.right.left, key);
                    // Do first rotation for root.right
                    if (root.right.left != null) root.right = rightRotate(root.right);
                } else if (root.right.key < key) {
                    // Zag-Zag (Right Right)
                    // Bring the key as root of right-right and do first rotation
                    root.right.right = splay(root.right.right, key);
                    root = leftRotate(root);
                }
                // Do second rotation for root
                return (root.right == null) ? root : leftRotate(root);
            }
        }

        // Function to insert a new key in splay tree with given root
        Node insert(Node root, int key) {
            // Simple Case: If tree is empty
            if (root == null) return new Node(key);
            // Bring the closest leaf node to root
            root = splay(root, key);

            // If key is already present, then return
            if (root.key == key) return root;

            // Otherwise allocate memory for new node
            Node newNode = new Node(key);

            // If root's key is greater, make root as right child of newNode
            // and copy the left child of root to newNode
            if (root.key > key) {
                newNode.right = root;
                newNode.left = root.left;
                root.left = null;
            }

            // If root's key is smaller, make root as left child of newNode
            // and copy the right child of root to newNode
            else {
                newNode.left = root;
                newNode.right = root.right;
                root.right = null;
            }
            return newNode; // newNode becomes new root
        }

        // The delete function for Splay tree.
        // Note that this function returns the new root of Splay Tree after removing the key
        Node delete(Node root, int key) {
            if (root == null) return null;
            // Splay the given key
            root = splay(root, key);
            // If key is not present, then return root
            if (key != root.key) return root;
            // If key is present. If left child of root does not exist make root.right as root
            if (root.left == null) root = root.right;
                // Else if left child exits
            else {
                Node temp = root;
                /* Note: Since key == root.key, so after Splay(root.left, key),
                 the tree we get will have no right child tree and maximum node in
                 left subtree will get splayed */
                root = splay(root.left, key); // New root
                // Make right child of previous root  as new root's right child
                root.right = temp.right;
            }
            // return root of the new Splay Tree
            return root;
        }

        // The search function for Splay tree. Note that this function returns the
        // new root of Splay Tree. If key is present in tree then, it is moved to root.
        Node find(Node root, int key) {
            return splay(root, key);
        }

        // A utility function to print preorder traversal of the tree.
        void preOrder(Node root) {
            if (root != null) {
                System.out.printf("%d ", root.key);
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        void inOrder(Node root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.key + " ");
                inOrder(root.right);
            }
        }

        void postOrder(Node root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.key + " ");
            }
        }
    }

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }
}