package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static util.PrintColor.ANSI_RED;
import static util.PrintColor.ANSI_RESET;

public class LinkedListTest {

    public static void main(String[] args) {
        List<String> list = createLinkedListOfStrings();
        System.out.println(list + ANSI_RED + " - initial list" + ANSI_RESET);

        System.out.println(list.subList(3, 6) + ANSI_RED + " - sublist" + ANSI_RESET);
        list.subList(3, 7).clear();
        System.out.println(list + ANSI_RED + " - sublist.clear()" + ANSI_RESET);
        list.clear();
        System.out.println(list + ANSI_RED + " - clear()" + ANSI_RESET);

        list = createLinkedListOfStrings();
        Collections.sort(list);
        System.out.println(list + ANSI_RED + " - natural order of sorting" + ANSI_RESET);

        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list + ANSI_RED + " - order by length" + ANSI_RESET);

        list = createLinkedListOfStrings();
        list.sort(Comparator.comparing(String::length));
        System.out.println(list + ANSI_RED + " - order by length" + ANSI_RESET);
    }

    static List<String> createLinkedListOfStrings() {
        List<String> list = new LinkedList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        return list;
    }
}
