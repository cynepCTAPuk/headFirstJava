package storage;

public class BiTreeBox implements IBox {
    private int size;
    private TreeNode root;

    public BiTreeBox() {
        size = 0;
        root = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(String item) {
        root = put(root, item);
    }

    private TreeNode put(TreeNode node, String item) {
        if (node == null) return new TreeNode(item);
        if (item.compareTo(node.getItem()) < 0) node.less = put(node.less, item);
        else node.less = put(node.more, item);
        return node;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean has(String item) {
        return has(root, item);
    }

    private boolean has(TreeNode node, String item) {
        if (node == null) return false;
        if (item.equals(node.getItem())) return true;
        return has(item.compareTo(node.getItem()) < 0 ? node.less : node.more, item);
    }
}

class TreeNode {
    private String item;
    TreeNode less;
    TreeNode more;

    public TreeNode(String item) {
        this.item = item;
        less = more = null;
    }

    public String getItem() {
        return item;
    }
}