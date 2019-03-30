/*
E - element
K - key
N - number
T - Type
V - Value
S,U,V etc.
 */
package com.javacode.generics;

import java.util.*;

public class GenericsMain {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 0, 8, 5, 6};

        Number n = Integer.valueOf(20);
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printElements(list);

        MyBox<Integer> myBox = new MyBox<>("");
        System.out.println(MyBox.returnValue(0.03));

        printElements(Arrays.asList(intArray));
    }

    private static void printElements(List<Number> list) {
        for(Number n: list) System.out.print(n + " ");
        System.out.println();
    }
}
