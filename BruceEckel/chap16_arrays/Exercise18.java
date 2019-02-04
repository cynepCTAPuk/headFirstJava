package chap16_arrays;
// Using System.arraycopy()

import java.util.*;

import static util.Print.*;

public class Exercise18 {
    public static void main(String[] args) {
        // Objects:
        BerylliumSphere[] u = new BerylliumSphere[6];
        BerylliumSphere[] v = new BerylliumSphere[3];
        Arrays.fill(u, new BerylliumSphere());
        print("u = " + Arrays.toString(u));
        Arrays.fill(v, new BerylliumSphere());
        print("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length/3, v.length);
        print("u = " + Arrays.toString(u));
    }
} /* Output:
i = [47, 47, 47, 47, 47, 47, 47]
j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
j = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
k = [47, 47, 47, 47, 47]
i = [103, 103, 103, 103, 103, 47, 47]
u = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
v = [99, 99, 99, 99, 99]
u = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
*///:~