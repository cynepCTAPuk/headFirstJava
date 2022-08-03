package algorithms;

import java.io.*;

public class MergeSortCountInversions {
    static long count = 0L;
    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] result = new int[a.length + b.length];
        for (int k = 0; k < result.length; k++) {
            if (j == b.length || (i < a.length && a[i] <= b[j])) {
                result[k] = a[i];
                i++;
            } else {
                count += a.length - i;
                result[k] = b[j];
                j++;
            }
        }
        return result;
    }

    private int[] mergeSort(int[] array) {
        if (array.length == 1) return array;
        int n = array.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];
        System.arraycopy(array, 0, left, 0, m);
        System.arraycopy(array, m, right, 0, n - m);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
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
        int[] a = new int[n];
        for (int i = 0; i < lines.length; i++) a[i] = Integer.parseInt(lines[i]);

/*
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
        System.out.println();
*/
//        System.out.println(Arrays.toString(merge(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6})));
        int[] sortedA = mergeSort(a);
//        for (int i = 0; i < n; i++) System.out.print(sortedA[i] + " ");
//        for (int i = 0; i < n - 1; i++) if (sortedA[i] > sortedA[i + 1]) throw new RuntimeException();
/*
        Arrays.sort(a);
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
*/
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new MergeSortCountInversions().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
