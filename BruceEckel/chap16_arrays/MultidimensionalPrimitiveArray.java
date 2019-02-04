package chap16_arrays;
//: arrays/MultidimensionalPrimitiveArray.java
// Creating multidimensional arrays.
import java.util.*;
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, },
                { 4, 5, 6, },
        };
        System.out.println(Arrays.deepToString(a));
        System.out.println(a[0][0] + " " + a[0][1] + " " + a[0][2]);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
    }
} /* Output:
[[1, 2, 3], [4, 5, 6]]
*///:~