import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
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

        int result = 0;
        for (int i = 0; i < size; i++) result = Math.max(result, d[i]);
        return result;
    }
}
