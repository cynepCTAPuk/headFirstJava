import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntPart {
    static List<Integer> list = new ArrayList<>();

    public static String part(long n) {
        eNum((int) n);
        list = list.stream().sorted().distinct().collect(Collectors.toList());
        int size = list.size();
        int range = list.get(size - 1) - list.get(0);
        double average = 0;
        double median;
        for (int element : list) average += element;
        average = average / size;
        if (size % 2 == 0) median = (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        else median = list.get(size / 2);
        return String.format("Range: %d Average: %.2f Median: %.2f", range, average, median);
    }

    static void eNum(int n) {
        int m = n;
        int[] arr = new int[(int) n];
        for (int i = 0; i < n; i++) arr[i] = 1;
        fill(arr, n);
        do {
            m = next(arr, m);
            fill(arr, m);
        } while (m > 1);
    }

    static int next(int[] arr, int m) {
        int i = (int) (m - 1);
        int sum = 0;
        do sum += arr[i--]; while (i > 0 && arr[i - 1] <= arr[i]);
        arr[i]++;
        m = i + sum;
        for (int j = i + 1; j < m; j++) arr[j] = 1;
        return m;
    }

    static void fill(int[] arr, int m) {
        int mult = 1;
        for (int i = 0; i < m; i++) {
            mult *= arr[i];
        }
        list.add(mult);
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(part(n));
    }
}