package test.Sorting;

import java.util.Arrays;

class Shake {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swap;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    swap = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swap;
                }
            }
            left++;
        }
    }

}
