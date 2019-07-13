public class Kata {
    public static int findEvenIndex(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr.length == 2) return -1;
        for (int j = 0; j < arr.length; j++) {
            int sumL = 0;
            int sumR = 0;
            for (int i = 0; i < j; i++) sumL += arr[i];
            for (int i = arr.length - 1; i > j; i--) sumR += arr[i];
            if (sumL == sumR) return j;
        }
        return -1;
    }
}