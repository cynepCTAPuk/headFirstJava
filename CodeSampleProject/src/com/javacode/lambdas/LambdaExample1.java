package com.javacode.lambdas;

import java.util.*;

public class LambdaExample1 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        processElements(intList, x -> Math.sqrt(x));
    }

    private static void processElements(List<Integer> intList, ElementProcessor1 function) {
        List<Double> doubleList = new ArrayList<>();
        for (Integer i : intList) {
            doubleList.add(function.process(i));
        }
        System.out.println(doubleList);
    }
}
