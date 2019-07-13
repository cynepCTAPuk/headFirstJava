public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if (h == 0 | window == 0 | h <= window) return -1;
        if (bounce <= 0 | bounce >= 1) return -1;
        int count = 1;
        while (h >= window) {
            h = h * bounce;
            if (h > window) count = count + 2;
        }
        return count;
    }
}