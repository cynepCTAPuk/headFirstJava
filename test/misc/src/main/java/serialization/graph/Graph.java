package serialization.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Graph{" + "nodes=" + nodes + '}';
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.setEdges(Arrays.asList(n2));
        n2.setEdges(Arrays.asList(n2, n4, n5));
        n4.setEdges(Arrays.asList(n1, n5));
        n5.setEdges(Arrays.asList(n4));
        n6.setEdges(Arrays.asList(n3));

        Graph graph = new Graph(Arrays.asList(n1, n2, n3, n4, n5, n6));

//        System.out.println(n1);
        System.out.println(graph);
    }
}
