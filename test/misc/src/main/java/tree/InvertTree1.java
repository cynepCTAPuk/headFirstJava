package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree1 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = node.left;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}
