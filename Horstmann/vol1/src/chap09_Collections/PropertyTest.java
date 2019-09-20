package chap09_Collections;

import java.util.Arrays;

public class PropertyTest {
    public static void main(String[] args) {
        String[] props = System
                .getProperties()
                .toString()
                .replace(",", "\n\t")
                .replace("=", " = ")
                .split("\n");
        Arrays
                .stream(props)
//                .sorted()
                .forEach(e -> System.out.println(e));
    }
}
