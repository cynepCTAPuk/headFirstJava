public class Kata {
    public static int findEvenIndex(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int sumLeft = arr[l];
        int sumRite = arr[r];
        while (l != (r - 2)) {
            if (sumLeft <= sumRite) sumLeft += arr[++l];
            else sumRite += arr[--r];
            System.out.println(l + ":" + r + " " + sumLeft + " - " + sumRite);
        }
        if (sumLeft == sumRite) return r;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println("*".repeat(10) + " " +
                findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println("*".repeat(10) + " " +
                findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
    }
}