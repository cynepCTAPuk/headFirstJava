public class FragBack {
    static int num = 0;

    static void print(int[] arr, int l) {
        for (int i = 0; i < l; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    static int next(int[] arr, int l) {
        int i = l - 1;
        int sum = 0;
        do sum += arr[i--]; while (i > 0 && arr[i - 1] <= arr[i]);
        arr[i]++;
        l = i + sum;
        for (int j = i + 1; j < l; j++) arr[j] = 1;
        return l;
    }

    static int next_back(int[] arr, int l, int n) {
        int i = l;
        do i--; while (i > 0 && arr[i] <= 1);
        arr[i]--;
        int sum = 0;
        int c = 0;
        while (arr[c] > 0) sum += arr[c++];
        int value = arr[i];
        do i++; while (arr[i] >= value);
        if (arr[i] == 0) c++;
        arr[i]++;
        return c;
    }

    static void run(int n) {
        int l = n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1;

        System.out.printf("%,3d: ",++num);
        print(arr, n);
        do {
            System.out.printf("%,3d: ",++num);
            l = next(arr, l);
            print(arr, l);
        } while (l > 1);
    }

    static void run_back(int n) {
        int[] arr = new int[n];
        int l = 1;
        arr[0] = n;
        print(arr, n);
        do {
            l = next_back(arr, l, n);
            print(arr, l);
        } while (l < n);
    }

    public static void main(String[] args) {
        run(8);
//        run_back(6);
    }
}