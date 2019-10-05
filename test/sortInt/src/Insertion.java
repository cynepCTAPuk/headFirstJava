import java.util.Arrays;

public class Insertion {

    public static void sort0(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static void sort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j > 0) && ((array[j - 1] - array[j]) > 0); j--) {
                swap(array, j - 1, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);
        double t0;

//        System.out.println(Arrays.toString(arr));

        int[] arr0 = arr.clone();
        t0 = System.nanoTime();
        Insertion.sort0(arr0);
        System.out.println(String.format("sort0\ttime nanoseconds\t%,9.0f", System.nanoTime() - t0));
//        System.out.println(Arrays.toString(arr0));

        int[] arr1 = arr.clone();
        t0 = System.nanoTime();
        Insertion.sort1(arr1);
        System.out.println(String.format("sort1\ttime nanoseconds\t%,9.0f", System.nanoTime() - t0));
//        System.out.println(Arrays.toString(arr1));
    }
}
