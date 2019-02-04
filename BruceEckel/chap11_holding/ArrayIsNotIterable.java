//: holding/ArrayIsNotIterable.java
package chap11_holding;
import java.util.*;
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib) System.out.print(t + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };
        // An array works in foreach, but it’s not Iterable:
//        test(chap13_strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
} /* Output:
1 2 3 A B C
*///:~