public class Fragmentation2 {
    static int num = 0;
    public static void ff(int k, int n) {
        if (k == 1) {
            System.out.printf("%d", n);
            System.out.printf("      -%d-\n", ++num);
            return;
        }
        for (int i = 1; i < n - k; i++) {
            System.out.printf("%d ", i);
            ff(k - 1, n - i);
        }

    }

    public static void main(String[] args) {
        int n = 8;
        for (int i = n; i > 0; i--) {
            ff(i, n);
        }
    }
}