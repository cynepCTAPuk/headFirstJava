package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(5, 0.7F,true);
        char a = 'a';
        int i = 5;
        for (int j = 0; j < 6; j++)
            map.put(i--, String.valueOf(a++));
        System.out.println(map.get(3) + " " + map.get(5) + " " + map.get(1));
        System.out.println(map);
        System.out.println("map.size: "+map.size());
    }
}
