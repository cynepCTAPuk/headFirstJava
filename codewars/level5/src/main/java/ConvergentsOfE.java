public class ConvergentsOfE {
    static int i = 21;

    public static int convergentsOfE(int m) {
        double mm = m * 1.0;
        double result;
        int[] n = {1, 3, 1, 8};

        return 0;
    }

    public static double exp(double mm) {
        double result = 0;
        while (i > 0) {
            i--;
            result = 1.0 / (mm + exp(mm));
            System.out.printf("%.16f\n", 1 + result);
        }
        return result;
    }

    public static double calcRoot(int num) {
        double guess = 0;
        double result = 6;
        int i =0;
        while (Math.abs(guess - result) != 0) {
            i++;
            guess = result;
            result = (guess + (num / guess)) / 2;
        }
        System.out.println(i);
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
//        System.out.println(exp(n) + " +++");
        System.out.println(calcRoot(n));
        System.out.println(Math.sqrt(n) + " ---");
    }
}