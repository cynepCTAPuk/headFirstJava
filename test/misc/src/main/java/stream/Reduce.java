package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reduce {
    public static void main(String[] args) {
        Integer[] integers = {2, 5, 8};
        Integer sum1 = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(sum1);
        Integer sum2 = Arrays.stream(integers).reduce(0, Integer::sum);
        System.out.println(sum2);
        Integer sum3 = Arrays.stream(integers).reduce(0, Reduce::add);
        System.out.println(sum3);
        Integer sum4 = Arrays.stream(integers).collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum4);
        Integer sum5 = Arrays.stream(integers).mapToInt(Integer::intValue).sum();
        System.out.println(sum5);
    }

    static int add(int a, int b) {
        return a + b;
    }
}
