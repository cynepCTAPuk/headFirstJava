/*
E - element
K - key
N - number
T - Type
V - Value
S,U,V etc.
 */
package com.javacode.generics;

public class GenericsMethods {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 0, 8, 5, 6};
        Double[] doubleArray = {0.2, 6.4, 9.03, 1.34, 4.67};
        String[] stringArray = {"abc", "def", "ghj", "klm"};
        printArray(intArray);
        printArray(doubleArray);
        printArray(stringArray);

        System.out.println(findMax(intArray));
        System.out.println(findMax(doubleArray));
        System.out.println(findMax(stringArray));
    }

    private static <T> void printArray(T[] array) {
        System.out.println("Generic method called");
        for (T element : array) System.out.printf("%s, ", element);
        System.out.println();
    }

    private static void printArray(Integer[] array) {
        System.out.println("Non generic method called");
        for (Integer element : array) System.out.printf("%s, ", element);
        System.out.println();
    }

    private static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) max = element;
        }
        return max;
    }

    private static <T extends Number & Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) max = element;
        }
        return max;
    }
}
