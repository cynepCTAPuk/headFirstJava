package string.task2208;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
/*
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
*/
    }

    public static String getQuery(Map<String, String> params) {
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null)
                list.add(entry.getKey() + " = '" + entry.getValue() + "'");
        }
        return String.join(" and ", list);
    }
}
