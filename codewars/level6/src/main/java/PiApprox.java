public class PiApprox {
    public static String iterPi2String(Double epsilon) {
        double pi = 1.0;
        int iteration = 1;
        int sign = 1;
        double divider = 1;
        while (((Math.PI - 4 * pi) > epsilon) | ((4 * pi - Math.PI) > epsilon)) {
            iteration += 1;
            sign = -sign;
            divider += 2;
            pi = pi + sign / divider;
        }
        return String.format("[%,d, %.10f]", iteration, 4 * pi);
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        double epsilon = 1.0 / n;
        System.out.println(iterPi2String(epsilon));

    }
}