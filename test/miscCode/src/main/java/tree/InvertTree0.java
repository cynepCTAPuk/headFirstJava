package tree;

public class InvertTree0 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = new TreeNode(root.val);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);
        return node;
    }
}
