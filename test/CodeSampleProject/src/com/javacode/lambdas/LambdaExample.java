package com.javacode.lambdas;

import java.util.*;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
    double process(T element);
}

interface ExecutiveFunction {
    void process();
}

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(8.6);
        doubleList.add(1.23);
        doubleList.add(4.13);
        doubleList.add(12.2);

//        processElements(intList, x -> Math.sin(x.doubleValue()));
//        processElements(doubleList, x -> Math.sin(x.doubleValue()));

        TimeUtil.measure(() -> Arrays.sort(createRandomArray()));

//        TimeUtil.measure(someLongRunningMethod())
    }

    private static <T extends Number> void processElements(
            List<T> intList, ElementProcessor function) {
        List<Double> doubleList = new ArrayList<>();
        for (Number i : intList) {
            doubleList.add(function.process(i));
        }
        System.out.println(doubleList);
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1_000_000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) myArray[i] = r.nextInt(myArray.length);
        return myArray;
    }

    public static class TimeUtil {
        private static void measure(ExecutiveFunction function) {
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();
            System.out.println("Time spent " + (end - start));
        }
    }
}
