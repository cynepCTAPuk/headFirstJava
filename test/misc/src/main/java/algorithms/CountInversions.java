package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountInversions {
    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("c:/000/input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();


    }

    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] result = new int[a.length + b.length];
        for (int k = 0; k < result.length; k++) {
            if (j == b.length || (i < a.length && a[k] < b[k])) {
                result[k] = a[k];
                i++;
            } else {
                result[k] = b[k];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new CountInversions().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
