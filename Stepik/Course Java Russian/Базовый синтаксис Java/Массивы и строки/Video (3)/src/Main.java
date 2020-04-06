// You can experiment here, it won’t be checked

import java.util.Arrays;

class Task {
    public static void main(String[] args) {
        // put your code here
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
        int[][] arr11 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr22 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.equals(arr11, arr22));
        System.out.println(Arrays.deepEquals(arr11, arr22));
        System.out.println(Arrays.toString(arr11));
        System.out.println(Arrays.deepToString(arr11));
    }
}
