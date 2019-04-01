package com.javacode.lambdas;

import com.javacode.lambdas.model.AnotherCircle;

import java.util.Arrays;
import java.util.Random;

public class LambdaExample5 {
    public static void main(String[] args) {
//        Operation.measure(() -> Arrays.sort(createRandomArray()));
        AnotherCircle anotherShape = new AnotherCircle();
        System.out.println(anotherShape.calcSomething());

        Operation operation1 = () -> Arrays.sort(createRandomArray());
        Operation operation2 = () -> Arrays.sort(createRandomArray());
        Operation.measure((operation1.combineOperation(operation2)));
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1_000_000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) myArray[i] = r.nextInt(myArray.length);
        return myArray;
    }
}
