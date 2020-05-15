package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
 * https://gist.github.com/nehaljwani/8243688
 * https://www.baeldung.com/java-avl-trees
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        System.out.println("Preorder traversal of constructed tree is : ");
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        tree.preOrder(tree.root);
        System.out.println();
        tree.print(tree.root);


        tree = new AVLTree();
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        System.out.println("Preorder traversal of constructed tree is : ");
        /* The constructed AVL Tree would be
              9
             / \
            1   10
           / \   \
          0   5   11
         /   / \
        -1  2   6
        */
        tree.preOrder(tree.root);
        System.out.println();
        tree.print(tree.root);

        tree.root = tree.deleteNode(tree.root, 10);
        System.out.println("Preorder traversal after deletion of 10 :");
        /* The AVL Tree after deletion of 10
              1
             / \
            0   9
           /   / \
          -1  5   11
             / \
            2   6
        */
        tree.preOrder(tree.root);
        System.out.println();
        tree.print(tree.root);

        System.out.println(tree.find(7));
    }

    private static class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    private static class AVLTree {
        Node root;

        private void updateHeight(Node y) {
            y.height = 1 + Math.max(height(y.left), height(y.right));
        }

        // A utility function to get the height of the tree
        int height(Node N) {
            if (N == null) return 0;
            return N.height;
        }

        // Get Balance factor of node N
        int getBalance(Node N) {
            if (N == null) return 0;
            return height(N.left) - height(N.right);
        }

        // A utility function to right rotate subtree rooted with y
        Node rightRotate(Node y) {
            Node x = y.left;
            Node z = x.right;

            // Perform rotation
            x.right = y;
            y.left = z;
            // Update heights
            updateHeight(y);
            updateHeight(x);
            // Return new root
            return x;
        }

        // A utility function to left rotate subtree rooted with x
        Node leftRotate(Node y) {
            Node x = y.right;
            Node z = x.left;

            // Perform rotation
            x.left = y;
            y.right = z;
            //  Update heights
            updateHeight(y);
            updateHeight(x);
            // Return new root
            return x;
        }

        Node insert(Node node, int key) {
            /* 1.  Perform the normal BST insertion */
            if (node == null) return (new Node(key));

            if (key < node.key) node.left = insert(node.left, key);
            else if (key > node.key) node.right = insert(node.right, key);
            else return node;   // Duplicate keys not allowed

            /* 2. Update height of this ancestor node */
            updateHeight(node);

            /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
            int balance = getBalance(node);
            // If this node becomes unbalanced, then there are 4 cases:

            // Left Left Case
            if (balance > 1 && key < node.left.key) return rightRotate(node);

            // Left Right Case
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Right Case
            if (balance < -1 && key > node.right.key) return leftRotate(node);

            // Right Left Case
            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

        /* Given a non-empty binary search tree, return the node with minimum key
            value found in that tree. Note that the entire tree does not need to be searched. */
        Node minValueNode(Node node) {
            Node current = node;
            /* loop down to find the leftmost leaf */
            while (current.left != null) current = current.left;
            return current;
        }

        Node deleteNode(Node root, int key) {
            // STEP 1: PERFORM STANDARD BST DELETE
            if (root == null) return null;
            // If the key to be deleted is smaller than the root's key,
            // then it lies in left subtree
            if (key < root.key) root.left = deleteNode(root.left, key);
                // If the key to be deleted is greater than the root's key,
                // then it lies in right subtree
            else if (key > root.key) root.right = deleteNode(root.right, key);
                // if key is same as root's key, then this is the node to be deleted
            else {
                // node with only one child or no child
                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;
                    // No child case
                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else // One child case
                        root = temp; // Copy the contents of
                    // the non-empty child
                } else {
                    // node with two children: Get the inorder successor (smallest in the right subtree)
                    Node temp = minValueNode(root.right);
                    // Copy the inorder successor's data to this node
                    root.key = temp.key;
                    // Delete the inorder successor
                    root.right = deleteNode(root.right, temp.key);
                }
            }
            // If the tree had only one node then return
            if (root == null) return null;

            // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
            updateHeight(root);

            // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
            // this node became unbalanced)
            int balance = getBalance(root);

            // If this node becomes unbalanced, then there are 4 cases

            // Left Left Case
            if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root);

            // Left Right Case
            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            // Right Right Case
            if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root);

            // Right Left Case
            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
            return root;
        }

        Node find(int key) {
            Node current = root;
            while (current != null) {
                System.out.println(current.key);
                if (current.key == key) break;
                current = current.key < key ? current.right : current.left;
            }
            return current;
        }

        // A utility function to print preorder traversal of the tree.
        void preOrder(Node node) {
            if (node != null) {
                System.out.printf("%2d ", node.key);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        void print(Node root) {
            if (root == null) {
                System.out.println("(XXXXXX)");
                return;
            }
            int height = root.height, width = (int) Math.pow(2, height - 1);
            // Preparing variables for loop.
            List<Node> current = new ArrayList<>(1), next = new ArrayList<>(2);
            current.add(root);
            final int maxHalfLength = 4;
            int elements = 1;
            StringBuilder sb = new StringBuilder(maxHalfLength * width);
            for (int i = 0; i < maxHalfLength * width; i++) sb.append(' ');
            String textBuffer;

            // Iterating through height levels.
            for (int i = 0; i < height; i++) {
                sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));
                // Creating spacer space indicator.
                textBuffer = sb.toString();
                // Print tree node elements
                for (Node n : current) {
                    System.out.print(textBuffer);
                    if (n == null) {
                        System.out.print("        ");
                        next.add(null);
                        next.add(null);
                    } else {
                        System.out.printf("(%6d)", n.key);
                        next.add(n.left);
                        next.add(n.right);
                    }
                    System.out.print(textBuffer);
                }
                System.out.println();
                // Print tree node extensions for next level.
                if (i < height - 1) {
                    for (Node n : current) {
                        System.out.print(textBuffer);
                        if (n == null)
                            System.out.print("        ");
                        else
                            System.out.printf("%s      %s",
                                    n.left == null ? " " : "/", n.right == null ? " " : "\\");
                        System.out.print(textBuffer);
                    }
                    System.out.println();
                }
                // Renewing indicators for next run.
                elements *= 2;
                current = next;
                next = new ArrayList<>(elements);
            }
        }
    }
}
// This code has been contributed by Mayank Jaiswal