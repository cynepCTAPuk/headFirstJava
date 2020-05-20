void setParents(List<Node> nodes) {
    // enter your code
}

interface Node{
    Node getLeft();
    Node getRight();
    Node getParent();
    void setParent(Node parent);
}