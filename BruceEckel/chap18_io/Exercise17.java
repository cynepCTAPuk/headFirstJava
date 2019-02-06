package chap18_io;
import util.*;

import java.util.*;
public class Exercise17 {
    public static void main(String[] args) {
        String file = "chap18_io/Exercise17.java";
        char[] chars = TextFile.read(file).toCharArray();

        Map<Character, Integer> treeMap = new TreeMap<>();
        for (Character c : chars) {
            if(c == '\n') continue;
            if (treeMap.containsKey(c)) treeMap.put(c, treeMap.get(c) + 1);
            else treeMap.put(c, 1);
        }
        System.out.println(treeMap);
    }
}
