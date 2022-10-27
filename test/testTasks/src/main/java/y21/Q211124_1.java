package y21;

public class Q211124_1 {

    public static void main(String[] args) {
        int k = 2;
        System.out.println(k << 3 >> k == k >> 1 << k);
        System.out.println(k << 3);
        System.out.println(k << 3 >> k);
        System.out.println(k >> 1);
        System.out.println(k >> 1 << k);
        System.out.println();
/*
        System.out.println(k << 1 >> k);
        System.out.println(k << 2 >> k);
        System.out.println(k << 3 >> k);
        System.out.println(k << 4 >> k);
        System.out.println(k << 5 >> k);
*/
        double a = 1.0;
        double b = 2.0;
        double c = a * b / 100 / 365 * 92;
        double d = a * b / 100. / 365. * 92;
        System.out.println(c);
        System.out.println(d);
        System.out.println(c == d);
    }
}