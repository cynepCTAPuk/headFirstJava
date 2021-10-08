package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapTest {
    public static void main(String[] args) {
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();
        map.put(20, 1);
        map.put(30, 2);
        for (Integer key : map.keySet()) {
            System.out.println(key);
            map.put(40, 0);
        }
        map.keySet().forEach(key -> {
            System.out.println(map.get(key));
            map.put(40, 3);
        });
    }
}
