package algorithms;

/**
 * https://www.geeksforgeeks.org/splay-tree-set-1-insert/
 * https://www.geeksforgeeks.org/splay-tree-set-2-insert-delete/
 */
public class SplayTreeTest {
    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(200);
        tree.root.left.left = new Node(40);
        tree.root.left.left.left = new Node(30);
        tree.root.left.left.left.left = new Node(20);

        System.out.println("Preorder traversal of the Splay tree is:");
        tree.preOrder(tree.root);
        System.out.println();

        tree.root = tree.search(tree.root, 20);
        System.out.println("Preorder traversal of the modified Splay tree after search is:");
        tree.preOrder(tree.root);
        System.out.println();

        tree.root = tree.insert(tree.root, 25);
        System.out.println("Preorder traversal of the modified Splay tree after insert is:");
        tree.preOrder(tree.root);
        System.out.println();
    }

    private static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
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

            // Key lies in left subtree
            if (root.key > key) {
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

        // The search function for Splay tree. Note that this function returns the
        // new root of Splay Tree. If key is present in tree then, it is moved to root.
        Node search(Node root, int key) {
            return splay(root, key);
        }

        // A utility function to print preorder traversal of the tree.
        // The function also prints height of every node
        void preOrder(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }
    }
}
// This code is contributed by 29AjayKumar

