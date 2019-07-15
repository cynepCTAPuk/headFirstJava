class RuleOfDivisibilityBy13_2 {
    private static final int[] a = {1, 10, 9, 12, 3, 4}; //pattern

    public static long thirt(long n) {
        long r = 0;
        String s = "" + n;
        for (int i = s.length() - 1; i >= 0; --i)
            r += (s.charAt(i) - '0') * a[(s.length() - i - 1) % 6];
        if (r == n)
            return r;
        return thirt(r);
    }

    public static void main(String[] args) {
        System.out.println(thirt(1234567));
    }
}