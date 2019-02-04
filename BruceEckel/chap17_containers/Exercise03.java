package chap17_containers;

import java.util.*;

import static util.Countries.*;

public class Exercise03 {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < 3; i++) hashSet.add(names().get(0));
        System.out.println(hashSet.size() + " " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) linkedHashSet.add(names().get(50));
        System.out.println(linkedHashSet.size() + " " + linkedHashSet);

        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 3; i++) treeSet.add(names().get(100));
        System.out.println(treeSet.size() + " " + treeSet);
    }
}
