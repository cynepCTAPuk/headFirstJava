package chap17_containers;

import util.*;

import java.util.*;

public class Exercise13 {

    public static void main(String[] args) {
        String file = "chap17_containers/Exercise13.java";
        List<String> arrayList = new ArrayList<>( new TextFile(file,"\\W+"));
        System.out.println(arrayList.size() + " " + arrayList);
        Set<String> treeSet = new TreeSet<>(arrayList);
        System.out.println(treeSet.size() + " " + treeSet);
    }
}
