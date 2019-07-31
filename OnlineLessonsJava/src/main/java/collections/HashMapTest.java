package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        char a = 'a';
        int i = 5;
        for (int j = 0; j < 5; j++)
            map.put(i--, String.valueOf(a++));
        System.out.println(map);
    }
}
