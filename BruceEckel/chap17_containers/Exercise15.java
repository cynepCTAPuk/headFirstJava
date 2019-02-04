package chap17_containers;
import util.*;

import java.util.*;
public class Exercise15 {
    public static void main(String[] args) {
        String file = "chap17_containers/Exercise13.java";
        List<String> arrayList = new ArrayList<>(new TextFile(file, "\\W+"));

        Map<String, Integer> map = new SlowMap<>();
        for (String s : arrayList) {
            if (map.containsKey(s)) {
                int v = map.get(s);
                map.put(s, ++v);
            } else { map.put(s, 1); }
        }
        System.out.println(map.size() + " " + map);
    }
}
