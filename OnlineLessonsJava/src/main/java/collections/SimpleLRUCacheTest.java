package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCacheTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new SimpleLRUCache<>(2);
        char a = 'a';
        for (int j = 1; j < 26; j++, a++) System.out.print(j + ":" + a + " ");
        System.out.println();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.get(2);
        map.put(9, "i");
        System.out.println(map);
        System.out.println("map.size: " + map.size());

    }
}
