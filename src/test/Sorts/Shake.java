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
        System.out.println("Shake cycles\t" + String.format("%,d", count));

    }

    public static void main(String[] args) {
        int[] array = new int[100];
        NewArray.fillRandom(array);

        int[] arrayShake;
        arrayShake = array.clone();
        System.out.println(Arrays.toString(arrayShake));

        double t0 = System.nanoTime();
        Shake.sort(arrayShake);
        double tShake = System.nanoTime() - t0;

        System.out.println(Arrays.toString(arrayShake));
        System.out.println("Shake time nanoseconds\t" + String.format("%,.0f", tShake));
    }
}
