//: containers/Maps.java
// Things you can do with Maps.
package chap17_containers;
import util.*;

import java.util.*;

import static util.Print.*;
public class Exercise16 {
    public static void printKeys(Map<Integer,String> map) {
        printnb("Size = " + map.size() + ", ");
        printnb("Keys: ");
        print(map.keySet()); // Produce a Set of the keys
    }
    public static void test(Map<Integer,String> map) {
        print("----- " + map.getClass().getSimpleName() + " -----");
        map.putAll(new CountingMapData(19));
        // Map has ‘Set’ behavior for keys:
        map.putAll(new CountingMapData(19));
        printKeys(map);
        // Producing a Collection of the values:
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty() after map.clear(): " + map.isEmpty());
        System.out.println(map);
        map.putAll(new CountingMapData(17));
        // Operations on the Set change the Map:
        printKeys(map);
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty() after map.keySet().removeAll(map.keySet()): " + map.isEmpty());
        System.out.println(map);
    }
    public static void main(String[] args) {
        test(new SlowMap<Integer,String>());
    }
}