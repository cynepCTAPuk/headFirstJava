package collections;

import java.util.*;

public class SpliteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(1);
        list.add(10);
        list.add(11);
        list.add(2);
        Spliterator<Integer> spliterator = list.spliterator();
        spliterator.forEachRemaining(i -> {
            if (i % 2 == 0) System.out.print(i + " ");
        });
        newLineDivider("Spliterator.forEachRemaining() if (i % 2 == 0)");

        List<Integer> lst = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 1, 2));
        Spliterator<Integer> split = lst.spliterator();
        split.trySplit().forEachRemaining(System.out::print);
        newLineDivider("Spliterator.trySplit()");
        split.forEachRemaining(System.out::print);
        newLineDivider("Spliterator.forEachRemaining()");

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) System.out.print(listIterator.nextIndex() + ":" + listIterator.next() + " ");
        newLineDivider("ListIterator.hasNext() nextIndex():next()");
    }

    private static void newLineDivider(String title) {
        System.out.println("\n" + "-".repeat(10) + " " + title);
    }
}
