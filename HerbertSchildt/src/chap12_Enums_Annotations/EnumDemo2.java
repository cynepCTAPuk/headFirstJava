package chap12_Enums_Annotations;

import java.util.Arrays;

// Use the built-in enumeration methods
public class EnumDemo2 {
    public static void main(String[] args) {
        Apple apple;
        System.out.println("Here are all Apple constants");

        // use values()
        Apple allapples[] = Apple.values();
        System.out.println(Arrays.toString(allapples));
        for (Apple a : allapples) System.out.println(a);

        // use valueOf()
        apple = Apple.valueOf("Winesap");
        System.out.println("apple contains " + apple);
    }
}
