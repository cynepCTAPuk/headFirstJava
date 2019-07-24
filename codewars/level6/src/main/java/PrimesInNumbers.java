public class PrimesInNumbers {
    public static String factors(int n) {
        String result = "";
        for (int fac = 2; fac <= n; ++fac) {
            int count;
            for (count = 0; n % fac == 0; ++count) n /= fac;
            if (count > 0) result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(factors(86240));
//        System.out.println(factors(7775460));
        System.out.println(factors(1089));
        System.out.println(factors(9801));
        System.out.println(factors(2178));
        System.out.println(factors(8712));
    }
}