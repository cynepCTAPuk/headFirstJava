package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort {
    private int[] a;
    private int[] temp;
    private int count;

    private void merge(int l, int m, int r) {
//        a[l... m - 1] & a[m... r - 1] -> temp[l... r-1] -> a[l... r-1]
        int i = l;
        int j = m;
        for (int k = l; k < r; k++) {
            if (j == r || (i < m && a[i] <= a[j])) {
                temp[k] = a[i];
                i++;
            } else {
                count += m - i;
                temp[k] = a[j];
                j++;
            }
        }
        System.arraycopy(temp, l, a, l, r - l);
    }

    private void mergeSort(int l, int r) {
        if (r - l <= 1) return;
        int m = (l + r) >> 1;
        mergeSort(l, m);
        mergeSort(m, r);
        merge(l, m, r);
    }

    private void run() throws IOException {
/*
        Scanner in = new Scanner(new File("c:/000/input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
*/
        BufferedReader reader = new BufferedReader(new FileReader("c:/000/input.txt"));
        int n = Integer.parseInt(reader.readLine());
        String[] lines = reader.readLine().split(" ");
        a = new int[n];
        for (int i = 0; i < lines.length; i++) a[i] = Integer.parseInt(lines[i]);
        temp = new int[n];
        mergeSort(0, n);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new MergeSort().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
