/**
 * Even Fibonacci numbers
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class n002 {
    public static void main(String[] args) {
        int previous = 0;
        int current = 1;
        int next;
        int sum = 0;
        int n = 4_000_000;
//        int n = 10;
//        for (int i = 1; i < n; i++) System.out.print(fibonacci(i) + ", ");
        System.out.println();
        while (current < n) {
            System.out.printf("%,d  ", current);
            next = previous + current;
            if (next % 2 == 0) sum += next;
            previous = current;
            current = next;
        }
        System.out.printf("\n%d", sum);
    }

    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 1 | n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
