package chap11_holding;

//: holding/SimpleCollection.java
import java.util.*;

public class SimpleCollectionSet {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++) c.add(random.nextInt(10) + 1); // Autoboxing
        System.out.println("Size collection = " + c.size());
        for(Integer i : c) System.out.print(i + ", ");
    }
} /* Output:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
*///:~