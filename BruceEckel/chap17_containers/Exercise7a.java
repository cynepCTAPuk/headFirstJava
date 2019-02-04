package chap17_containers;

import util.*;

import java.util.*;

public class Exercise7a {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(5));
        Iterator<String> ita = arrayList.iterator();
        while (ita.hasNext()) System.out.print(ita.next() + " ");
        System.out.println();

        List<String> linkedList = new LinkedList<>(Arrays.asList("12345".split("")));
        Iterator<String> itl = linkedList.iterator();
        while (itl.hasNext()) System.out.print(itl.next() + " ");
        System.out.println();

        ListIterator<String> lit1 = arrayList.listIterator(arrayList.size());
        while (lit1.hasPrevious()) {
            lit1.previous();
            lit1.add(((LinkedList<String>) linkedList).pollFirst());
            lit1.previous();
        }
        System.out.println(arrayList);

    }
}
