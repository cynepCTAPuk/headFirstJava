package collections;

public class LinkedListElementTest {
    public static void main(String[] args) {
        //хвост (самый последний элемент) списка
        LinkedListElement<Integer> tail = new LinkedListElement<>();
        for (int i = 0; i < 10; i++) {
            LinkedListElement<Integer> element = new LinkedListElement<>();
            element.data = i;

            if (tail == null) { //если в хвосте нет элементов, сделать наш элемент последним
                tail = element;
            } else {    //если хвост есть, добавить элемент
                tail.next = element; //добавляем хвосту ссылку на следующий элемент
                element.previous = tail; //добавляем новому элементу ссылку на хвост
                tail = element; //объявляем новый элемент хвостом.
            }
        }
    }

    private static class LinkedListElement<T>{
        public T data;
        public LinkedListElement<T> next;
        public LinkedListElement<T> previous;
    }
}

