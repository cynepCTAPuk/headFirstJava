package t22;

import java.util.ArrayList;
import java.util.List;

public class Q220603_3 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.stream().forEach(s->{
            System.out.println(s);
            list.add(s + "New"); // java.util.ConcurrentModificationException
        });
    }
}