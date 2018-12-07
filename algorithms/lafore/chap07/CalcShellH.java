package lafore.chap07;

import java.util.*;

public class CalcShellH {
    public static void main(String[] args) {
        int n = 15;
        int[] h = new int[n];
        int hh = 0;
        for (int i = 0; i < n; i++) {
            hh = hh * 3 + 1;
            h[i] = hh;
        }
        System.out.format("%,9d", 10_000_000 / 2);
        System.out.println();
//        System.out.println(Arrays.toString(h));
//        System.out.print("[");
        for (int i = 0; i < h.length; i++) {
            System.out.format("%,3d - %-,12d%n", i, h[i]);
        }
//        System.out.println("]");
    }
}
