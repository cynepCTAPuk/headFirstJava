public class PrimesInNumbers1 {
    public static String factors(int n) {
        int factor = 2;
        StringBuffer result = new StringBuffer();
        while (n != 1) {
            if (count(n, factor) != 0) {
                result.append("(").append(factor);
                if (count(n, factor) != 1) result.append("**").append(count(n, factor));
                result.append(")");
            }
            n = (int) (n / Math.pow(factor, count(n, factor)));
            factor++;
        }
        return result.toString();
    }

    static int count(int n, int factor) {
        int k = 0;
        while (n % factor == 0) {
            k++;
            n /= factor;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(factors(86240));
        System.out.println(factors(7775460));
    }
}