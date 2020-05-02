package algorithms;

public class Test821 {
    public static void main(String[] args) {
        int[] a = {3, 6, 7, 6};
        System.out.println(lisBottomUp(a));
    }

    private static int lisBottomUp(int[] a) {
        int size = a.length;
        int[] d = new int[size];

        for (int i = 0; i < size; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++)
                if (a[i] >= a[j] && d[i] < d[j] + 1 && a[i] % a[j] == 0)
                    d[i] = d[j] + 1;
        }
        printArray(a);
        printArray(d);

        int result = 0;
        for (int i = 0; i < size; i++) result = Math.max(result, d[i]);
        return result;
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) System.out.printf("%3d,", array[i]);
            else System.out.printf("%3d]%n", array[i]);
        }
    }
}
