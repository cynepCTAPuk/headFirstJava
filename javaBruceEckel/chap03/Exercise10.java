package chap03;

public class Exercise10 {
    public static void main(String[] args) {
        int b = 2;
        int a0 = 0, a1 = 1, a2 = 2, a3 = 3, a4 = 4, a5 = 5, a6 = 6, a7 = 7;
        int i1 = pow(b, a1) + pow(b, a2) + pow(b, a5) + pow(b, a6);
        int i2 = pow(b, a0) + pow(b, a2) + pow(b, a4) + pow(b, a6);

        System.out.format("i1%10s %,4d\ni2%10s %,4d\n"
                , Integer.toBinaryString(i1), i1, Integer.toBinaryString(i2), i2);

        System.out.format("& %10s\n| %10s\n^ %10s\n"
                , Integer.toBinaryString(i1 & i2)
                , Integer.toBinaryString(i1 | i2)
                , Integer.toBinaryString(i1 ^ i2));

        System.out.format("%,d\n", pow(4, 3));
        System.out.format("%,d\n", power(4, 3));
    }

    static int pow(int base, int exp) {
        if (exp < 0) return -1;
        if (exp == 0) return 1;
        return pow(base, exp - 1) * base;
    }

    static int power(int base, int exp) {
        if (exp < 0) return -1;
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;

    }

}
