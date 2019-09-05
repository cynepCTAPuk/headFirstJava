package chap09_Collections;

import java.util.Arrays;

public class PropertyTest {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));
        String[] props = System.getProperties().toString()
                .replace(",", "\n\t")
                .replace("=", " = ").split("\n");
        Arrays.stream(props).sorted().forEach(e-> System.out.println(e));
/*
        System.out.println(System.getProperties().toString()
                .replace(", ", ",\n")
                .replace("=", " = ")
//                .replace(";", "\n\t\t")
        );
*/
    }
}
