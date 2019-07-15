class RuleOfDivisibilityBy13 {
    private static final long[] ints = {1, 10, 9, 12, 3, 4, 1, 10, 9, 12, 10, 10};

    public static long thirt(long n) {
        long previousResult = 0;
        while (previousResult != n) {
            previousResult = n;
            n = getSum(n);
        }
        return n;
    }

    private static long getSum(long n) {
        long result = 0;
        int i = 0;
        while (n > 0) {
            result += (n % 10) * ints[i++];
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(thirt(1234567));
    }
}