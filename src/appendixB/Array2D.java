package appendixB;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        int[][] a2d = new int[5][25];
        System.out.println("a2d.length \t" + a2d.length);
        System.out.println("a2d[0].length \t" + a2d[0].length);

        for (int i = 0; i < a2d.length; i++) {
            for (int j = 0; j < a2d[i].length; j++) {
                a2d[i][j] = i + j;
                System.out.print(a2d[i][j]+"\t");
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(a2d));
        for (int i = 0; i < a2d.length ; i++) {
            System.out.println(Arrays.toString(a2d[i]));
        }
    }
}
