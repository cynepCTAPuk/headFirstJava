package chap17_containers;

import java.util.*;

class SortedSet<T> extends LinkedList<T> {
    int compare(T t1, T t2) {
        int difference = t1.hashCode() - t2.hashCode();
        return difference < 0 ? -1 : (difference == 0 ? 0 : 1);
    }
    public boolean add(T t) {
        if(!this.contains(t)) {
            Iterator<T> iterator = this.iterator();
            int index = 0;
            while(iterator.hasNext()) {
                if(compare(iterator.next(),t) < 1) index++;
            }
            add(index,t);
            return true;
        }
        return false;
    }
}
public class Exercise10 {
    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new SortedSet<>();
        for (int i = 10; i > 0 ; i--) sortedSet.add(i);
        System.out.println(sortedSet);
    }
}
