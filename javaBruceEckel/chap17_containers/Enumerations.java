//: containers/Enumerations.java
// Java 1.0/1.1 Vector and Enumeration.
package chap17_containers;
import util.*;
import java.util.Vector;
import java.util.*;
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(8));
        Enumeration<String> e = v.elements();
        while(e.hasMoreElements()) System.out.print(e.nextElement() + ", ");
        // Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<>());
    }
} /* Output:
ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC,
*///:~