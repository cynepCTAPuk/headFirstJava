package interview;

/**
 * Однонаправленный связанный список
 * Необходимо реализовать функцию reverse:
 * на вход функция получает head связанного списка;
 * внутри функции нужно перевернуть связанный список;
 * функция должна вернуть head нового связанного списка.
 * Sample Input:
 * 10
 * Sample Output:
 * input:    0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * expected: 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
 * actual:   9, 8, 7, 6, 5, 4, 3, 2, 1, 0
 */
public class Test116 {
    public static void main(String[] args) {
        NodeI head = new NodeI(0);
        Node current = head;
        for (int i = 1; i < 5; i++) {
            Node temp = new NodeI(i);
            current.setNext(temp);
            current = temp;
        }

        System.out.println(traverse(head));
        System.out.println(traverse(reverse(head)));
    }

    static Node reverse(Node head) {
        if (head == null) return null;
        Node tmp = head;
        head = head.getNext();
        tmp.setNext(null);
        while (head != null) {
            tmp = head;
            head = head.getNext();
            head.setNext(tmp);
        }
        return head;
    }

    static String traverse(Node head) {
        String result = "";
        while (head != null) {
            result += head.getI() + ", ";
            head = head.getNext();
        }
        return result.substring(0, result.length() - 2);
    }
}

class NodeI implements Node {
    private Node next;
    private int i;

    public NodeI(int i) {
        this.i = i;
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
    public int getI() {
        return i;
    }
}

interface Node {
    Node getNext();

    void setNext(Node next);

    int getI();
}
