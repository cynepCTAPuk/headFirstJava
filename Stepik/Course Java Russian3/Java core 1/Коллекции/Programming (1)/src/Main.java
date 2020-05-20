class TreeIterator implements Iterator<Node> {
    private final Node root;

    public TreeIterator(Node root) {
        this.root = root;
    }

    @Override
    public boolean hasNext() {
        // enter your code
        return false;
    }

    @Override
    public Node next() {
        // enter your code
        return null;
    }
}

interface Node{
    Node getLeft();
    Node getRight();
}