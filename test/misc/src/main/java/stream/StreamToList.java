package stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToList {
    public static void main(String[] args) {
        // Stream of Integers
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 78, 9, 10, 3, 2, 34, 5, 3);

        // 1. Stream to List
        List<Integer> list = input.stream().parallel().collect(Collectors.toList());
        System.out.println("Stream to List: " + list);
        // Stream to ArrayList
        ArrayList<Integer> arrayList = input.stream().parallel().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Stream to ArrayList: " + arrayList);
        // Stream to LinkedList
        LinkedList<Integer> linkedList = input.stream().parallel().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Stream to LinkedList: " + linkedList);
        System.out.println("-".repeat(50));

        // 2. Stream to Set
        Set<Integer> set = input.stream().parallel().collect(Collectors.toSet());
        System.out.println("Stream to Set: " + set);
        // Stream to HashSet
        HashSet<Integer> hashSet = input.stream().parallel().collect(Collectors.toCollection(HashSet::new));
        System.out.println("Stream to HashSet: " + hashSet);
        // Stream to TreeSet
        TreeSet<Integer> treeSet = input.stream().parallel().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Stream to TreeSet: " + treeSet);
        // Stream to LinkedHashSet
        LinkedHashSet<Integer> linkedHashSet = input.stream().parallel().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Stream to LinkedHashSet: " + linkedHashSet);
        System.out.println("-".repeat(50));

        // 3. Stream to Map
        Map<Integer, String> map = input.stream().collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1));
        System.out.println("Stream to Map: " + map);
        // Stream to HashMap
        HashMap<Integer, String> hashMap = input.stream().collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, HashMap::new));
        System.out.println("Stream to HashMap: " + hashMap);
        // Stream to TreeMap
        TreeMap<Integer, String> treeMap = input.stream().collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, TreeMap::new));
        System.out.println("Stream to TreeMap: " + treeMap);
        // Stream to LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = input.stream().collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, LinkedHashMap::new));
        System.out.println("Stream to LinkedHashMap: " + linkedHashMap);
        System.out.println("-".repeat(50));

        // 4. Stream to ConcurrentMap
        ConcurrentMap<Integer, String> concurrentMap = input.parallelStream().collect(Collectors.toConcurrentMap(Function.identity(), String::valueOf, (k1, k2) -> k1));
        System.out.println("Stream to ConcurrentMap: " + concurrentMap);
        // Stream to ConcurrentHashMap
        ConcurrentHashMap<Integer, String> concurrentHashMap = input.parallelStream().collect(Collectors.toConcurrentMap(Function.identity(), String::valueOf, (k1, k2) -> k1, ConcurrentHashMap::new));
        System.out.println("Stream to ConcurrentHashMap: " + concurrentHashMap);
    }
}
