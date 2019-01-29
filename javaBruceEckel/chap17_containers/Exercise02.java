package chap17_containers;

import java.util.*;

import static util.Countries.*;

public class Exercise02 {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>(capitals());
        System.out.println("treeMap " + treeMap);
        System.out.println(treeMap.size());
        Set<String> treeSet = new TreeSet<>(names());
        System.out.println("treeSet " +treeSet);
        System.out.println(treeSet.size());
    }
}
