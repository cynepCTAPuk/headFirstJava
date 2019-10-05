import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] arr = {10, 11, 1, 3, 5, 7, 2, 4, 6, 8, 10, 11};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(merge(arr1, arr2)));
        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] aux = arr.clone();
        aux = mergeSort(arr);
    }

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (arr == null) return null;
        if (n < 2) return arr;
        else {
            int k = n / 2;
            int[] arr1 = new int[k];
            int[] arr2 = new int[n - k];
            for (int i = 0; i < k; i++) arr1[i] = arr[i];
            for (int i = 0; i < n - k; i++) arr2[i] = arr[k + i];
//            System.arraycopy(arr, 0, arr1, 0, k);
//            System.arraycopy(arr, k, arr2, 0, n - k);
            return merge(mergeSort(arr1), mergeSort(arr2));
        }
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return null;
        int n1 = arr1.length, n2 = arr2.length;
        int[] arr = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < (n1 + n2)) {
            if ((k == n2) || ((j < n1) && (arr1[j] < arr2[k])))
                arr[i++] = arr1[j++];
            else
                arr[i++] = arr2[k++];
        }
        return arr;
    }
}
