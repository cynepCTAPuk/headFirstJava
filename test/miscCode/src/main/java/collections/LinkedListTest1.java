package collections;

public class LinkedListTest1 {
    public static void main(String[] args) {
        //хвост (самый последний элемент) списка
        LinkedListElement<Integer> head = new LinkedListElement<>();
        for (int i = 0; i < 10; i++) {
            LinkedListElement<Integer> element = new LinkedListElement<>();
            element.data = i;

            if (head == null) { //если в хвосте нет элементов, сделать наш элемент последним
                head = element;
            } else {    //если хвост есть, добавить элемент
                head.next = element; //добавляем хвосту ссылку на следующий элемент
                element.previous = head; //добавляем новому элементу ссылку на хвост
                head = element; //объявляем новый элемент хвостом.
            }
        }
        head.print();
    }

    private static class LinkedListElement<T> {
        public T data;
        public LinkedListElement<T> next;
        public LinkedListElement<T> previous;

        public void print() {
            LinkedListElement<T> current = this;
            while (current != null) {
                System.out.println(current.data);
                current = previous;
            }
        }
    }
}

