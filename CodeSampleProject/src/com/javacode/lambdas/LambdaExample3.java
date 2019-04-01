package com.javacode.lambdas;

import java.util.*;

public class LambdaExample3 {
    public static void main(String[] args) {
        Operation.measure(() -> Arrays.sort(createRandomArray()));

//        TimeUtil.measure(someLongRunningMethod())
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1_000_000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) myArray[i] = r.nextInt(myArray.length);
        return myArray;
    }
}
