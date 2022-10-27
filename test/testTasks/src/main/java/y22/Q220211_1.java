package y22;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q220211_1 {
    public static void main(String[] args) {
//        float f = 1.0 + 1.0f;

        Integer[] integers = {1, 2, 3};
//        List<Integer> listOf = List.of(1, 2, 3);
        List<Integer> asList = Arrays.asList(integers);
        List<Integer> unmodif = Collections.unmodifiableList(asList);

//        listOf.set(0, 9);
        integers[0] = 0;

//        System.out.println(listOf);
        System.out.println(asList);
        System.out.println(unmodif);
    }
}

