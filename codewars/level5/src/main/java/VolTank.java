public class VolTank {
    public static int tankVol(int h, int d, int vt) {
        if (h < 0 | h > d)
            throw new RuntimeException("H must be positive and not more than D");
        double pi = Math.PI;
        double squareRound = pi * d * d / 4;
        double tankDepth = vt / squareRound;
        double result;
        if (h <= d / 2) result = squareSegment(h, d);
        else result = squareRound - squareSegment(h, d);
        return (int) (result * tankDepth);
    }

    private static double squareSegment(int h, int d) {
        double r = d / 2.0;
        double a = Math.abs(r - h);
        double b = Math.sqrt(r * r - a * a);
        double angle = 2 * Math.acos(a / r);
        double sector = r * r * angle / 2;
        double triangle = a * b;
        return sector - triangle;
    }

    public static void main(String[] args) {
        System.out.println(tankVol(5, 7, 3848));
        System.out.println(tankVol(2, 7, 3848));

        System.out.println(tankVol(7, 7, 3848));
        System.out.println(tankVol(0, 7, 3848));
    }
}