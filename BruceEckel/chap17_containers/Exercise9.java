package chap17_containers;

import util.*;

import java.util.*;

public class Exercise9 {
    public static void main(String[] args) {
        RandomGenerator.String generator = new RandomGenerator.String(3);
        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 5 ; i++) { treeSet.add(generator.next()); }
        System.out.println(treeSet);
    }
}
