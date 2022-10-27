package y21;

import java.util.Arrays;

public class Q210929_2 {
    public static void main(String[] args) {
        int[] i1[] = {{1, 2, 3}, {0, 0, 0}};
        int[][] i2 = {{1, 2, 3}, {0, 0, 0,}};
        int[][] i3 = new int[2][3];
        print(i1);
        print(i2);
        print(i3);
        System.arraycopy(i1, 0, i3, 0, i3.length);
        System.out.println(Arrays.equals(i1, i2));
        System.out.println(Arrays.equals(i1, i3));
        System.out.println(Arrays.deepEquals(i1, i2));

        System.out.println(Arrays.toString(i1));
        System.out.println(Arrays.toString(i2));
        System.out.println(Arrays.toString(i3));

        print(i3);
        i3[0][0] = 999;
        print(i1);

    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(Arrays.toString(arr[i]));
        System.out.println();
    }
}

