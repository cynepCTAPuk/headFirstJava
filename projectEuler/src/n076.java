import java.util.*;

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
public class n076 {
    public static void main(String[] args) {
        int target = 100;
        int[] ways = new int[target + 1];
        ways[0] = 1;

        for (int i = 1; i <= 99; i++) {
            for (int j = i; j <= target; j++) {
                ways[j] += ways[j - i];
            }
        }
        System.out.println(Arrays.toString(ways));
    }
}
