import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SplayTree tree = new SplayTree();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            char ch = line[0].charAt(0);
            int a = tree.func(Integer.parseInt(line[1]));
            switch (ch) {
                case '+':
                    tree.root = tree.insert(tree.root, a);
                    break;
                case '-':
                    tree.root = tree.delete(tree.root, a);
                    break;
                case '?':
                    tree.root = tree.find(tree.root, a);
                    if (tree.root == null) System.out.println(
                                    "Not found");
                    else System.out.println(
                                    (tree.root.key == a ? "Found" : "Not found"));
                    break;
                case 's':
                    int b = tree.func(Integer.parseInt(line[2]));
                    tree.s = tree.sum(a, b);
                    System.out.println(
                                    tree.s);
                    break;
            }
        }
    }

    private static class SplayTree {
        Node root;
        int s = 0;

        int func(int x) {
            return (x + s) % 1_000_000_001;
        }

        int sum(int a, int b) {
            int sum = 0;
            root = find(root, a);
            Queue<Node> queue = new LinkedList<>();
            if (root != null && root.key >= a && root.key <= b) {
                sum += root.key;
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                sum += node.key;
                Node left = node.left;
                Node right = node.right;
                if (left != null && left.key >= a && left.key <= b) {
                    sum += left.key;
                    queue.add(left);
                }
                if (right != null && right.key >= a && right.key <= b) {
                    sum += right.key;
                    queue.add(right);
                }
            }
            return sum;
        }

        private Node rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;
            return y;
        }

        private Node leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            return y;
        }

        private Node splay(Node root, int key) {
            if (root == null || root.key == key) return root;
            if (root.key > key) {
                if (root.left == null) return root;
                if (root.left.key > key) {
                    root.left.left = splay(root.left.left, key);
                    root = rightRotate(root);
                } else if (root.left.key < key) {
                    root.left.right = splay(root.left.right, key);
                    if (root.left.right != null) root.left = leftRotate(root.left);
                }
                return (root.left == null) ? root : rightRotate(root);
            } else {
                if (root.right == null) return root;
                if (root.right.key > key) {
                    // Bring the key as root of right-left
                    root.right.left = splay(root.right.left, key);
                    // Do first rotation for root.right
                    if (root.right.left != null) root.right = rightRotate(root.right);
                } else if (root.right.key < key) {
                    root.right.right = splay(root.right.right, key);
                    root = leftRotate(root);
                }
                return (root.right == null) ? root : leftRotate(root);
            }
        }

        Node insert(Node root, int key) {
            if (root == null) return new Node(key);
            root = splay(root, key);
            if (root.key == key) return root;
            Node newNode = new Node(key);
            if (root.key > key) {
                newNode.right = root;
                newNode.left = root.left;
                root.left = null;
            } else {
                newNode.left = root;
                newNode.right = root.right;
                root.right = null;
            }
            return newNode;
        }

        Node delete(Node root, int key) {
            if (root == null) return null;
            root = splay(root, key);
            if (key != root.key) return root;
            if (root.left == null) root = root.right;
            else {
                Node temp = root;
                root = splay(root.left, key); // New root
                root.right = temp.right;
            }
            return root;
        }

        Node find(Node root, int key) {
            return splay(root, key);
        }

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