package chap11;

import java.util.*;

public class Exercise14 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            ListIterator<Integer> li = list.listIterator(list.size() / 2);
            list.add(li.nextIndex(), i);
        }
        System.out.println(list);
    }
}
