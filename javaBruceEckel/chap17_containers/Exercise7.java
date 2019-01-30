package chap17_containers;

import util.*;

import java.util.*;

public class Exercise7 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Countries.names(5));
        Iterator<String> ita = arrayList.iterator();
        while (ita.hasNext()) System.out.print(ita.next() + " ");
        System.out.println();

        List<String> linkedList = new LinkedList<>(Countries.names(5));
        Iterator<String> itl = linkedList.iterator();
        while (itl.hasNext()) System.out.print(itl.next() + " ");
        System.out.println();

        ListIterator<String> lit = arrayList.listIterator();
        while (lit.hasNext()) {
            lit.next();
            lit.add(((LinkedList<String>) linkedList).pollFirst());
        }
        System.out.println(arrayList);
    }
}
