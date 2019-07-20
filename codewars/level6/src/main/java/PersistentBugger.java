class PersistentBugger {
    public static int persistence(long n) {
        long m = n;
        int steps = 0;
        while (String.valueOf(m).length() > 1) {
            steps++;
            long[] ints = digits(m);
            m = 1;
            for (long e : ints) m *= e;
        }
        return steps;
    }

    static long[] digits(long n) {
        int length = String.valueOf(n).length();
        long[] ints = new long[length];
        for (int i = 0; i < length; i++) {
            ints[i] = n % 10;
            n /= 10;
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(4));
        System.out.println(persistence(25));
        System.out.println(persistence(999));
    }
}