public class VolTank1 {
    public static int tankVol(int h, int d, int vt) {
        double cos = 1.0 - 2.0 * h / d;
        double theta = Math.acos(cos);
        return (int) (vt * (theta - Math.sin(theta) * cos) / Math.PI);
    }

    public static void main(String[] args) {
        System.out.println(tankVol(5, 7, 3848));
        System.out.println(tankVol(2, 7, 3848));
    }
}