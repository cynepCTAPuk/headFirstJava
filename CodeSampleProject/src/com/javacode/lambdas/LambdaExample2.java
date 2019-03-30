package com.javacode.lambdas;

import java.util.*;

@java.lang.FunctionalInterface
interface ElementProcessor2 {
    double process(int element, int elem2);
}

public class LambdaExample2 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        processElements(intList, 4, (x, y) -> Math.pow(x, y));
        processElements(intList, 4, (x, y) -> multiply(x, y));
    }

    private static void processElements(List<Integer> intList, int y, ElementProcessor2 function) {
        List<Double> doubleList = new ArrayList<>();
        for (Integer i : intList) doubleList.add(function.process(i, y));
        System.out.println(doubleList);
    }

    private static double multiply(int x, int y) {
        return x * y / 10.0;
    }
}
