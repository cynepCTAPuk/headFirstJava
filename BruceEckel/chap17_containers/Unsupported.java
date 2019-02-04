//: containers/Unsupported.java
// Unsupported operations in Java containers.
package chap17_containers;
import java.util.*;
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("\n--- " + msg + " ---");
        Collection<String> c1 = list;
        System.out.println("c1 = list " + c1);
        Collection<String> subList = list.subList(1,8);
        System.out.println("sublist 1-8 " + subList);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);
        System.out.println("c2 = sublist " + c2);
        try { c1.retainAll(c2); } catch(Exception e) {
            System.out.println("retainAll(): " + e); }
        try { c1.removeAll(c2); } catch(Exception e) {
            System.out.println("removeAll(): " + e); }
        try { c1.clear(); } catch(Exception e) {
            System.out.println("clear(): " + e); }
        try { c1.add("X"); } catch(Exception e) {
            System.out.println("add(): " + e); }
        try { c1.addAll(c2); } catch(Exception e) {
            System.out.println("addAll(): " + e); }
        try { c1.remove("C"); } catch(Exception e) {
            System.out.println("remove(): " + e); }
        // The List.set() method modifies the value but
        // doesn’t change the size of the data structure:
        try { list.set(0, "X"); System.out.println("list " + list);
        } catch(Exception e) { System.out.println("List.set(): " + e); }
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList( new ArrayList<String>(list)));
    }
} /* Output:
--- Modifiable Copy ---
--- Arrays.asList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
--- unmodifiableList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
List.set(): java.lang.UnsupportedOperationException
*///:~