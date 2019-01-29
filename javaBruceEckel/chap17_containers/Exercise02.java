package chap17_containers;

import java.util.*;

import static util.Countries.*;

public class Exercise02 {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>(capitals(8));
        System.out.println("hashMap " + hashMap);

        List<String> linkedList = new LinkedList<>(names(7));
        System.out.println("linkedList " +linkedList);
        Collections.shuffle(linkedList);
        System.out.println("linkedList " +linkedList);
    }
}
