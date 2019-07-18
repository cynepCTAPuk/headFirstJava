public class FragForw {
    static int num = 0;

    static void print(int[] arr, int l) {
        for (int i = 0; i < l; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int next(int[] arr, int l) {
        int i = l - 1;
        int sum = 0;
        do {
            sum += arr[i--];
        } while (i > 0 && arr[i - 1] <= arr[i]);
        arr[i]++;
        l = i + sum;
        for (int j = i + 1; j < l; j++) arr[j] = 1;
        return l;
    }

    static void run(int n) {
        int l = n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1;
        System.out.printf("%3s: %2s:\n","num", "l");
        System.out.printf("%,3d: %2d: ",++num, l);
        print(arr, n);
        do {
            System.out.printf("%,3d: %2d: ",++num, l);
            l = next(arr, l);
            print(arr, l);
        } while (l > 1);
    }

    public static void main(String[] args) {
        run(100);
    }
}