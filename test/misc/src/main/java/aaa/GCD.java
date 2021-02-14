package aaa;

public class GCD {
    public static void main(String[] args) {
        int a = 13;
        int b = 182;
        System.out.println(gcd(a, b));
    }

public static int gcd(int a, int b) {
    int max = Math.max(a, b);
    int min = Math.min(a, b);
    while (max > min) {
        System.out.println(max + ":" + min);
        int c = max - min;
        max = Math.max(c, min);
        min = Math.min(c, min);
    }
    return min;
}
}
