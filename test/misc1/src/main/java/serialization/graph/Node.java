package serialization.graph;

import java.util.List;

public class Node {
    private int number;
    private List<Node> edges;

    public Node(int node) {
        this.number = node;
    }

    public void setEdges(List<Node> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        String ed = "";
//        for (Node n : edges) ed += n.number;

        int size = 0;
        if (edges != null) size = edges.size();
        return "\n\tNode{" + "node=" + number + ", qtyEdge=" + size +
                '}';
    }
}
