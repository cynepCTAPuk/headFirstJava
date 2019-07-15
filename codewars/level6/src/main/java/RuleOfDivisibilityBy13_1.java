class RuleOfDivisibilityBy13_1 {

    public static long thirt(long n) {
        long result = n;
        long previousResult = 0;
        while (previousResult != result) {
            previousResult = result;
            result = getSum(result);
        }
        return result;
    }

    private static long getSum(long n) {
        long[] ints = {1, 10, 9, 12, 3, 4, 1, 10, 9, 12, 10, 10};
        long[] start = new long[(n + "").length()];
        int i = 0;
        while (n > 0) {
            long digit = n % 10;
            start[i++] = digit;
            n = n / 10;
        }
        int result = 0;
        for (int j = 0; j < start.length; j++) result += start[j] * ints[j];
        return result;
    }
}