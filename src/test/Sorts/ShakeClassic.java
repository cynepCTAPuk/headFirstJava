package test.Sorts;

import java.util.Arrays;

class ShakeClassic {
    static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swap;
        int count = 0;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                count++;
                if (array[i - 1] > array[i]) {
                    swap = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = swap;
                }
            }
            left++;
        }
        System.out.println("ShakeC cycles\t" + String.format("%,d", count));
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        NewArray.fillRandom(array);

        int[] arrayShakeClassic;
        arrayShakeClassic = array.clone();
        System.out.println(Arrays.toString(arrayShakeClassic));

        double t0 = System.nanoTime();
        ShakeClassic.sort(arrayShakeClassic);
        double tShakeClassic = System.nanoTime() - t0;

        System.out.println(Arrays.toString(arrayShakeClassic));
        System.out.println("ShakeClassic time nanoseconds\t" + String.format("%,.0f", tShakeClassic));

    }

}
