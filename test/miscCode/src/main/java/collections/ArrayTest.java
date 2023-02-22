package collections;

import java.util.Arrays;

class ArrayTest {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[][] a1 = {arr1};
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.deepToString(a1));
		int[] arr2 = new int[]{1, 2, 3};
		int[][] a2 = {arr2};
		int[][] arr3 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.deepToString(arr3));
		int[][] arr4 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

		System.out.println(Arrays.deepEquals(a1, a2));
		System.out.println(Arrays.deepEquals(arr3, arr4));
	}
}