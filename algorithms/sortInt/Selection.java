package sortInt;

import tools.*;

import java.util.*;

public class Selection {
    public static void sort(int[] array) {
        int left = 0, right = array.length - 1;
        int n = 0;
        while (left < right) {
            int min = left;
            System.out.format("%-2d = %s%n",n++, Arrays.toString(array));

            for (int i = left; i < right; i++) {
                if (array[min] > array[i + 1]) {
                    min = i + 1;
                    System.out.format("\tmin = %d",array[min]);
                }
            }
            System.out.println();
            int temp = array[left];
            array[left] = array[min];
            array[min] = temp;
            left++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[20];
        Utils.fillRandom100(array);
//    System.out.println(Arrays.toString(array));
        Selection.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
