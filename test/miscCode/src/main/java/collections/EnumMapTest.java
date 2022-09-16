//https://www.baeldung.com/java-enum-map
package collections;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapTest {
    public static void main(String[] args) {
//        Creation
        EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY, "Soccer");
        activityMap.put(DayOfWeek.TUESDAY, "Basketball");
        System.out.println(activityMap);
//        EnumMap Copy Constructor
        EnumMap<DayOfWeek, String> activityMapCopy = new EnumMap<>(activityMap);
        System.out.println(activityMapCopy);
//        Map Copy Constructor
        Map<DayOfWeek, String> ordinaryMap = new HashMap();
        ordinaryMap.put(DayOfWeek.MONDAY, "Soccer");
        System.out.println(ordinaryMap);
        EnumMap enumMap = new EnumMap(ordinaryMap);
        System.out.println(enumMap);
//        Adding and Retrieving Elements
        activityMap.put(DayOfWeek.WEDNESDAY, "Hiking");
        System.out.println(activityMap);
        System.out.println(activityMap.get(DayOfWeek.WEDNESDAY));
        System.out.println(activityMap.get(DayOfWeek.SUNDAY));
//        Checking for Elements
        System.out.println(activityMap.containsValue("Hiking"));
//        Removing Elements
        System.out.println(activityMap.remove(DayOfWeek.MONDAY));
        System.out.println(activityMap);
//        Collection Views
        System.out.println(activityMap.values());
        System.out.println(activityMap.keySet());
        System.out.println(activityMap.entrySet());
    }

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}

