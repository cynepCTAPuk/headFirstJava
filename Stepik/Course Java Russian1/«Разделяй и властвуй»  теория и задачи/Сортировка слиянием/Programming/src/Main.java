import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static long sum = 0L;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int maxN = (int) Math.pow(2, (int) Math.ceil((Math.log(n) / Math.log(2))));
        int[] array = new int[maxN];

        for (int i = maxN - n; i < maxN; i++) {
            array[i] = scanner.nextInt();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < maxN; i++) {
            queue.add(new int[]{array[i]});
        }

        while (queue.size() > 1) queue.add(merge(queue.poll(), queue.poll()));
        System.out.println(sum);
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (idx1 == arr1.length) {
                for (int j = idx2; j < arr2.length; j++) {
                    result[i++] = arr2[j];
                }
            } else if (idx2 == arr2.length) {
                for (int j = idx1; j < arr1.length; j++) {
                    result[i++] = arr1[j];
                }
            } else {
                if (arr1[idx1] <= arr2[idx2]) {
                    result[i] = arr1[idx1++];
                } else {
                    result[i] = arr2[idx2++];
                    sum += arr1.length - idx1;
                }
            }
        }
        return result;
    }
}
