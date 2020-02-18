package collections.task2601;
/**
 * сортировка по удаленности от медианы
 */

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
/*
        Integer[] array = {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int size = array.length;
        int median;
        if (size % 2 == 0) median = (array[size / 2 - 1] + array[size / 2]) / 2;
        else median = array[size / 2];

        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs(o - median)));
        return array;
    }
}
