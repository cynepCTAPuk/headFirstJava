public class PrimeDecomp {
    public static String factors(int n) {
        int m = 2;
        StringBuffer result = new StringBuffer();
        while (n != 1) {
            if (qty(n, m) != 0) {
                result.append("(").append(m);
                if (qty(n, m) != 1) result.append("**").append(qty(n, m));
                result.append(")");
            }
            n = (int) (n / Math.pow(m, qty(n, m)));
            m++;
        }
        return result.toString();
    }

    static int qty(int n, int m) {
        int k = 0;
        while (n % m == 0) {
            k++;
            n /= m;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(factors(86240));
        System.out.println(factors(7775460));
    }
}