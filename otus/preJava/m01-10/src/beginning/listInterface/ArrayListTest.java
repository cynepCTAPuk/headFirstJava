package beginning.listInterface;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        int capacity = 11;
        List<Integer> list = new ArrayList<Integer>(capacity + 1);
        System.out.print("arrayList.size -\t" + list.size());
        System.out.println("\tarrayList.isEmpty -\t" + list.isEmpty());

//        for (int i = 0; i < capacity; i++) list.add(String.valueOf(i));
        for (int i = 0; i < capacity; i++) list.add(i);
        System.out.print("arrayList.size -\t" + list.size());
        System.out.println("\tarrayList.isEmpty -\t" + list.isEmpty());

        Collections.shuffle(list);
        System.out.println("arrayList " + list + " shuffle");

        Collections.reverse(list);
        System.out.println("arrayList " + list + " reverse");

        Collections.sort(list);
        System.out.println("arrayList " + list + " sort");

        Collections.rotate(list, 3);
        System.out.println("arrayList " + list + " rotate, 3");


    }
}
