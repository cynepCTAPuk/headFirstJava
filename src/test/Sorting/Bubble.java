package test.Sorting;

import java.util.Arrays;

class Bubble {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swap;
        boolean b = true;
        while (b) {
            b = false;
            for (int i = left; i < right; i++) {
                b = true;
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            right--;
        }
    }
}
