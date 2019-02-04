//: arrays/MultidimensionalObjectArrays.java
package chap16_arrays;
import java.util.*;
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                { new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
        };
        System.out.println(Arrays.deepToString(spheres));
        System.out.println(Arrays.toString(spheres[0]));
        System.out.println(Arrays.toString(spheres[1]));
        System.out.println(Arrays.toString(spheres[2]));
    }
} /* Output:
[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3, Sphere 4, Sphere 5], [Sphere 6, Sphere 7, Sphere 8, Sphere 9, Sphere 10, Sphere 11, Sphere 12, Sphere 13]]
*///:~