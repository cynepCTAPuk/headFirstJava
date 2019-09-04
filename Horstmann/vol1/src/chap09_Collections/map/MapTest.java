package chap09_Collections.map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 *
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

//        System.out.println(staff);                                        // print all entries
        staff.remove("567-24-2546");                                 // remove an entry
        staff.put("456-62-5527", new Employee("Francesca Miller")); // replace an entry
//        System.out.println(staff.get("157-62-7935"));                     // look up a value

        // iterate through all entries
//        staff.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        var treeMap = new TreeMap<Employee, Integer>(Comparator.comparing(Employee::toString));
//        var treeMap = new TreeMap<Employee, Integer>(); //java.lang.ClassCastException
        treeMap.put(new Employee("CTAPuk"), 1);
        treeMap.put(new Employee("Ivan"), 3);
        treeMap.put(new Employee("Anna"), 1);
//        System.out.println(treeMap);

        System.out.println("-".repeat(60) + " print map.keySet & values ");
        System.out.println(staff.keySet());
        System.out.println(staff.values());

        System.out.println("-".repeat(60) + " print map.entrySet ");
        System.out.println(staff.entrySet());

        System.out.println("-".repeat(60) + " for map.keySet() print map.get(key)");
        for (String key : staff.keySet()) System.out.println(key + ":" + staff.get(key));

        System.out.println("-".repeat(60) + " for map.entrySet() print entry");
//        for (Map.Entry<String, Employee> entry : staff.entrySet()) System.out.println(entry);
        for (var entry : staff.entrySet()) System.out.println(entry);

        System.out.println("-".repeat(60) + " map.forEach");
        staff.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
