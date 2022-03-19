package part01;

import java.util.*;
import java.util.stream.Collectors;

public class task01 {
    public static void main(String[] args) {
        String str = "ДоброПожаловать";
        // 0
        Map<Integer, Integer> map1 = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
            int ch = str.codePointAt(i);
            if (map1.containsKey(ch)) map1.put(ch, map1.get(ch) + 1);
            else map1.put(ch, 1);
        }
        print(map1);
        // 1
        Map<Character, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map2.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        System.out.println(map2);
        // 2
        Map<Character, Long> map3 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map3);
        print2hearts();
    }

    static void print(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
    }

    static void print2hearts() {
        System.out.println(String.valueOf(Character.toChars(128149)));
    }
}
