import java.util.Arrays;

public class Kata1 {
    public static int findEvenIndex(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr.length == 2) return -1;
        int l = 0;
        int r = arr.length - 1;
        int sumL = arr[l];
        int sumR = arr[r];
        int sumA = Arrays.stream(arr).sum();
        while (l != (r - 2)) {
            if ((sumL <= sumR) && ((sumL + arr[l + 1])) < sumA / 2) sumL += arr[++l];
            else sumR += arr[--r];
        }
        if (sumL == sumR) return l + 1;
        else return -1;
    }
}