package ru.otus;

import java.util.*;

public class TestHashMap {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "1111");
        map.put("Petrov", "2222");
        map.put("Sidorov", "3333");
        System.out.println("Phone of Petrov: "+map.get("Petrov"));
        System.out.println(map);
        for (String key : map.keySet()) System.out.println(key + " \t" + map.get(key));
        map.forEach((key, value) -> System.out.println(key + " \t" + map.get(key)));
        System.out.println(map.containsKey("Kuznetsov"));
        map.put("Kuznetsov", "4444");
        System.out.println(map.containsKey("Kuznetsov"));
        System.out.println(map);
    }
}
