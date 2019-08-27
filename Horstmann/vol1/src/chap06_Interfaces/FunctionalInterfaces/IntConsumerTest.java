package chap06_Interfaces.FunctionalInterfaces;

import java.util.function.IntConsumer;

public class IntConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) action.accept(i);
    }
}
