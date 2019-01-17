//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}
package strings;
import java.util.*;
public class InfiniteRecursion {
    public String toString() {
//        return " InfiniteRecursion address: " + this + "\n";
        return "\n" + super.toString();
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for(int i = 0; i < 10; i++) v.add(new InfiniteRecursion());
        System.out.println(v);
    }
} ///:~