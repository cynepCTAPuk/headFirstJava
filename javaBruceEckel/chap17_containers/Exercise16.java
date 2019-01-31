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
        System.out.println(map);
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
    }
    public static void main(String[] args) {
        test(new SlowMap<Integer,String>());
    }
}