class TriangleTester {
    public static boolean isTriangle(int a, int b, int c) {
        if (a <= 0 | b <= 0 | c <= 0) return false;
        return (a + b > c) && (b + c > a) && (c + a > b);
    }
}