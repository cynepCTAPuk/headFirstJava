/**
 * Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class n003 {
    public static void main(String[] args) {
        long n = 600_851_475_143L;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
                n /= i;
                i--;
            }
        }
        System.out.println(n);
    }
}
