//: containers/CollectionMethods.java
// Things you can do with all Collections.
package chap17_containers;
import java.util.*;
import util.*;
import static util.Print.*;
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.addAll(Countries.names(6));
        print("c1 " + c1);
        c1.add("ten");
        print("c1 " + c1);
        c1.add("eleven");
        print("c1 " + c1);
// Make an array from the List:
        Object[] array = c1.toArray();
        System.out.println("array " + Arrays.toString(array));
// Make a String array from the List:
        String[] str = c1.toArray(new String[0]);
        System.out.println("str " + Arrays.toString(str));
// Find max and min elements; this means different things
// depending on the way the Comparable interface is implemented:
        print("Collections.max(c1) = " + Collections.max(c1));
        print("Collections.min(c1) = " + Collections.min(c1));
// Add a Collection to another Collection
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        print("c2 " + c2);
        c1.addAll(c2);
        print("c1 + c2 " + c1);
        c1.remove(Countries.DATA[0][0]);
        print("c1 remove DATA[0][0] " + c1);
        c1.remove(Countries.DATA[1][0]);
        print("c1 remove DATA[1][0] " + c1);
// Remove all components that are in the argument collection:
        c1.removeAll(c2);
        print("c1 removeAll c2 " + c1);
        c1.addAll(c2);
        print("c1 addAll c2 " + c1);
// Is an element in this Collection?
        String val = Countries.DATA[3][0];
        print("c1.contains(" + val + ") = " + c1.contains(val));
// Is a Collection in this Collection?
        print("c1.containsAll(c2) = " + c1.containsAll(c2));
        Collection<String> c3 = ((List<String>)c1).subList(3, 5);
// Keep all the elements that are in both
// c2 and c3 (an intersection of sets):
        c2.retainAll(c3);
        print("c2 " + c2);
// Throw away all the elements
// in c2 that also appear in c3:
        c2.removeAll(c3);
        print("c2.isEmpty() = " + c2.isEmpty());
        c1 = new ArrayList<String>();
        c1.addAll(Countries.names(6));
        print("c1 " + c1);
        c1.clear(); // Remove all elements
        print("after c1.clear():" + c1);
    }
} /* Output:
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, ten, eleven]
Collections.max(c) = ten
Collections.min(c) = ALGERIA
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[BENIN, BOTSWANA, BULGARIA, BURKINA FASO, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
[ten, eleven]
[ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
c.contains(BOTSWANA) = true
c.containsAll(c2) = true
[ANGOLA, BENIN]
c2.isEmpty() = true
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
after c.clear():[]
*///:~