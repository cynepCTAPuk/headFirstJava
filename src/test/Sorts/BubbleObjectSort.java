package test.Sorts;

import java.util.Arrays;

import static test.Sorts.UtilsSort.print;

class BubbleObjectSort implements SortAlgorithm {
    /**
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    public <T extends Comparable<T>> T[] sort(T array[]) {
        int last = array.length;
        boolean swap;
        int count = 0;
        do {
            swap = false;
            for (int i = 0; i < last - 1; i++) {
                count++;
                if (UtilsSort.less(array[i], array[i + 1])) {
                    swap = UtilsSort.swap(array, i, i + 1);
                }
            }
            last--;
        } while (swap);
        System.out.println("BubbleS\tcycles\t" + String.format("%,d", count));
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        BubbleObjectSort bubbleObjectSort = new BubbleObjectSort();
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        String[] strings = {"c", "a", "e", "b", "d", "x", "n", "j", "g"};
//        UtilsSort.print(bubbleObjectSort.sort(integers));
//        UtilsSort.print(bubbleObjectSort.sort(strings));

        UtilsSort.print(integers);
        bubbleObjectSort.sort(integers);
        UtilsSort.print(integers);

        UtilsSort.print(strings);
        bubbleObjectSort.sort(strings);
        UtilsSort.print(strings);

    }
}
