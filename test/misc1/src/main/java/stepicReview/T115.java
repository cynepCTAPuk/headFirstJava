package stepicReview;

public class T115 {

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 1, 2, 3, 4, 5, 6, 7, 3, 1};
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int[] array2 = {};
        int[] array3 = {1};
        checkSortArrayLength(array);
        checkSortArrayLength(array1);
        checkSortArrayLength(array2);
        checkSortArrayLength(array3);
    }

static void checkSortArrayLength(int[] a) {
    if (a.length < 2) {
        System.out.println(a.length);
        return;
    }
    int maxA = 1;
    int maxB = 1;
    for (int i = 1; i < a.length; i++) {
        if (a[i] >= a[i - 1]) {
            ++maxB;
            if (maxB > maxA) maxA = maxB;
        } else maxB = 1;
    }
    System.out.println(maxA);
}
}
