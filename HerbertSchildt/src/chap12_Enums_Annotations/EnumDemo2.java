package chap12_Enums_Annotations;

import java.util.Arrays;

// Use the built-in enumeration methods
public class EnumDemo2 {
    public static void main(String[] args) {
        Apple1 apple;
        System.out.println("Here are all Apple constants");

        // use values()
        Apple1 allapples[] = Apple1.values();
        System.out.println(Arrays.toString(allapples));
        for (Apple1 a : allapples) System.out.println(a);

        // use valueOf()
        apple = Apple1.valueOf("Winesap");
        System.out.println("apple contains " + apple);
    }
}
