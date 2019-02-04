//: generics/ArrayMaker.java
package generics;
import java.lang.reflect.*;
import java.util.*;
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) { this.kind = kind; }
//    @SuppressWarnings("unchecked")
    T[] create(int size) { return (T[])Array.newInstance(kind, size); }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        stringArray[5] = "****";
        System.out.println(Arrays.toString(stringArray));

        Integer[] integers = (new ArrayMaker<>(Integer.class)).create(9);
        integers[0] = 1111;
        System.out.println(Arrays.toString(integers));
    }
} /* Output:
[null, null, null, null, null, null, null, null, null]
*///:~