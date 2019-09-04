package chap09_Collections.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        var staff = new LinkedHashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        System.out.println(staff.keySet());
        System.out.println(staff.values());
        for (var entry : staff.entrySet()) System.out.println(entry);

        System.out.println("-".repeat(60));
        staff.forEach((k, v) -> System.out.println(k + ":" + v));

        var cache =
                new LinkedHashMap<String, String>(128, 0.75F, true) {
                    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                        return size() > 100;
                    }
                };
    }
}
