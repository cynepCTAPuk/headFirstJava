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
 * https://www.geeksforgeeks.org/count-ofdifferent-ways-express-n-sum-1-3-4/
 */
public class n076_1 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countWays(n));
    }

    // Function to count the number of ways to represent n as sum of 1, 3 and 4
    static int countWays(int n) {
        int dp[] = new int[n + 1];

        // base cases
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;

        // iterate for all values from 4 to n
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
}
