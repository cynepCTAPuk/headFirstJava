public class Kata {
    public static int findEvenIndex(int[] arr) {
        int sumLeft = 0;
        int sumRite = 0;
        int l = 0;
        int r = arr.length;
        while (l != (r - 1)) {
            if (sumLeft <= sumRite) sumLeft += arr[l++];
            else sumRite += arr[--r];
            System.out.println(l + ":" + r + " " + sumLeft + " - " + sumRite);
        }
        if (sumLeft == sumRite) return l;
        else return -1;
    }

    public static void main(String[] args) {
//        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
    }
}