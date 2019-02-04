//: arrays/ThreeDWithNew.java
package chap16_arrays;
import java.util.*;
public class ThreeDWithNew {
    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(a[0]));
        System.out.println(Arrays.toString(a[0][0]));
    }
} /* Output:
[[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
*///:~