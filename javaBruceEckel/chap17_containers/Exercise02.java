package chap17_containers;

import java.util.*;

import static util.Countries.*;

public class Exercise02 {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>(capitals(2));
        System.out.println(treeMap.size() + " treeMap " + treeMap);
        Set<String> treeSet = new TreeSet<>(names(4));
        System.out.println(treeSet.size() + " treeSet " +treeSet);

        char ch = 'A';

        Map<String, String> map = new TreeMap<>();
        for (String s : capitals().keySet()) {
            if (s.charAt(0) == ch) map.put(s, capitals().get(s));
        }
        System.out.println(map.size() + " " + map);

        Set<String> set = new TreeSet<>();
        for (String s : names()) if (s.charAt(0) == ch) set.add(s);
        System.out.println(set.size() + " " + set);
    }
}
