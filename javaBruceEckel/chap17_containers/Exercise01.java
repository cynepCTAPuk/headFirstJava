package chap17_containers;
import java.util.*;

import static util.Countries.names;

public class Exercise01 {
    public static void main(String[] args) {
        List<String> arrayList = names(8);
        System.out.println("arrayList " + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("arrayList " + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("arrayList " + arrayList);
        Collections.shuffle(arrayList);
        System.out.println("arrayList " + arrayList);
        List<String> linkedList = new LinkedList<>(names(7));
        System.out.println("linkedList " +linkedList);
    }
}
