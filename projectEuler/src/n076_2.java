import java.util.Arrays;

/**
 * Counting summations
 * <p>
 * Problem 76
 * It is possible to write five as a sum in exactly six different ways:
 * <p>
 * 3 + 1
 * 2 + 2
 * 2 + 1 + 1
 * 1 + 1 + 1 + 1
 * <p>
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 * <p>
 * 5 + 1
 * 4 + 2
 * 4 + 1 + 1
 * 3 + 3
 * 3 + 2 + 1
 * 3 + 1 + 1 + 1
 * 2 + 2 + 2
 * 2 + 2 + 1 + 1
 * 2 + 1 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1 + 1
 * <p>
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 * <p>
 * https://codereview.stackexchange.com/questions/219250/project-euler-76-counting-summations
 */
public class n076_2 {
    public static void main(String[] args) {
        int i, j;
        int[] way = new int[101];

        way[0] = 1;
        for (i = 99; i >= 1; i--)
            for (j = i; j <= 100; j++)
                way[j] = way[j] + way[j - i];

        System.out.println(Arrays.toString(way));
        System.out.println(way[100]);
    }
}
