package t22;

import java.util.stream.IntStream;

public class Q220518_1 {
    public static void main(String[] args) {
        IntStream.of(3, 2, 6, 1, 4, 7, 5)
                .peek(System.out::print)
                .filter(i -> i > 4)
                .forEach(x -> System.out.print("\t - " + x + " - \n"));
    }
}

