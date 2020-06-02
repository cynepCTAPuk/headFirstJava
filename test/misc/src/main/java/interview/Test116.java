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

    }
    Node reverse(Node head) {
        Node tmp;
        while (head != null) {
            tmp = head.getNext();
            head.setNext(tmp);
        }
        return head;
    }
}

class NodeI implements Node {
    Node next;

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }
}

interface Node {
    Node getNext();

    void setNext(Node next);
}
