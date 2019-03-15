package tasks;

public class SortArray {
    public static void bubble(int[] array) {
        boolean check = true;
        int j = 0;
        int temp;
        while (check) {
            check = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    check = true;
                }
            }
        }
    }
}
