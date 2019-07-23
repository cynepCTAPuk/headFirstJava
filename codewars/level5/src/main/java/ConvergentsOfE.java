public class ConvergentsOfE {
    static int i = 21;

    public static int convergentsOfE(int m) {
        double mm = m * 1.0;
        double result;
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

    public static double calcRoot(double num) {
        double guess = 0;
        double result = 2;
        while (Math.abs(guess - result) != 0) {
            guess = result;
            result = (guess + (num / guess)) / 2;
            System.out.println(result);
        }
        return result;
    }

    public static double rootOfTwo(int iteration) {
        long[] top = new long[iteration];
        long[] bottom = new long[iteration];
        top[0] = 1;
        bottom[0] = 1;
        for (int i = 1; i < iteration; i++) {
            bottom[i] = top[i - 1] + bottom[i - 1];
            top[i] = bottom[i - 1] + bottom[i];
        }
        for (int j = 0; j < iteration; j++) System.out.printf("(%,d/%,d)", top[j], bottom[j]);
        System.out.println();
        return top[iteration - 1] * 1.0 / bottom[iteration - 1];
    }

    public static void main(String[] args) {
        int iteration = 50;
        System.out.println(rootOfTwo(iteration));
        System.out.println(Math.sqrt(2) + " --- Math.sqrt(2)");
//        System.out.println(rootOfTwo(iteration) - Math.sqrt(2));
    }
}