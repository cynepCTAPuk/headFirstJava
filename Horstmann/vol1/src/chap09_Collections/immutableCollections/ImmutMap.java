package chap09_Collections.immutableCollections;

import java.util.Map;

public class ImmutMap {
    public static void main(String[] args) {
        Map<String, String> names = Map.ofEntries(
                Map.entry("1", "Lokesh"),
                Map.entry("2", "Amit"),
                Map.entry("3", "Brian"));

        System.out.println(names);

        //UnsupportedOperationException
//        names.put("2", "Ravi");
//        names.replace("Amit", "CTAPuk");
        System.out.println(names.keySet());
        System.out.println(names.values());
    }
}
