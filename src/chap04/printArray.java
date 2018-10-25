package chap04;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class printArray {
    public static void main(String[] args) {
        String[] strArray = new String[] {"John", "Mary", "Bob"};
        System.out.println(Arrays.asList(strArray));
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.deepToString(strArray));
// #1
        Arrays.asList(strArray).stream().forEach(s -> System.out.println(s));
// #2
        Arrays.sort(strArray); //Sort Array Forward
        Stream.of(strArray).forEach(System.out::println);
// #3
        Arrays.sort(strArray,Collections.reverseOrder()); //Sort Array Reverse
        Arrays.stream(strArray).forEach(System.out::println);

    }
}
