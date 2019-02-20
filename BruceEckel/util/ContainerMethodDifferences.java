//: net/mindview/util/ContainerMethodDifferences.java
package util;
import java.lang.reflect.*;
import java.util.*;
public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for(Method m : type.getMethods()) result.add(m.getName());
        return result;
    }
    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<>();
        for(Class<?> c : type.getInterfaces()) result.add(c.getSimpleName());
        System.out.println(result);
    }
    static Set<String> object = methodSet(Object.class);
    static { object.add("clone"); }
    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName()
                + ", adds: ");
        Set<String> comp = Sets.difference( methodSet(superset), methodSet(subset));
        comp.removeAll(object); // Don’t run ‘Object’ methods
        System.out.println(comp);
        interfaces(superset);
    }
    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(List.class, Collection.class);
        difference(Queue.class, Collection.class);
        System.out.println("\nSet: " + methodSet(Set.class));
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        System.out.println("\nList: " + methodSet(List.class));
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("\nMap: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
} ///:~