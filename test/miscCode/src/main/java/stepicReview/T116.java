package stepicReview;

public class T116 {

    public static void main(String[] args) {
        Node node = createLinkedList(15);
        printLinkedList(node);
        Node reverse = reverseList(node);
        printLinkedList(reverse);
    }

    static void printLinkedList(Node node) {
        if (node == null) return;
        do {
            System.out.print(node + " ");
            node = node.getNext();
        } while (node != null);
        System.out.println();
    }

    static Node createLinkedList(int n) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new NodeI(i);
            if (head == null) head = node;
            else tail.setNext(node);
            tail = node;
        }
        return head;
    }

    static Node reverseList(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }
}

class NodeI implements Node {
    int value;
    Node next;

    public NodeI(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

interface Node {
    Node getNext();

    void setNext(Node next);
}
