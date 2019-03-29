package com.javacode.lambdas;

import java.util.*;

interface ExecutiveFunction3 {
    void process();
}

public class LambdaExample3 {
    public static void main(String[] args) {
        TimeUtil3.measure(() -> Arrays.sort(createRandomArray()));

//        TimeUtil.measure(someLongRunningMethod())
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1_000_000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) myArray[i] = r.nextInt(myArray.length);
        return myArray;
    }

    public static class TimeUtil3 {
        private static void measure(ExecutiveFunction3 function) {
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();
            System.out.println("Time spent " + (end - start));
        }
    }
}
