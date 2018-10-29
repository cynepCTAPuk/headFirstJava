package test.Sorts;

import java.util.Arrays;

class Shake {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swap, swappedLeft, swappedRight;
        int count = 0;
        while (left < right) {
            swappedRight = 0;
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                    swappedRight = i;
                }
            }
            right = swappedRight;
            swappedLeft = array.length - 1;
            for (int i = right; i > left; i--) {
                count++;
                if (array[i - 1] > array[i]) {
                    swap = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swap;
                    swappedLeft = i;
                }
            }
            left = swappedLeft;
        }
        System.out.println("Shake\tcycles\t" + String.format("%,d", count));

    }

}
