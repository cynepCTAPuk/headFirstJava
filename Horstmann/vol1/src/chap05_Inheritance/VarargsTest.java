package chap05_Inheritance;

public class VarargsTest {
    public static void main(String[] args) {
        System.out.println(max(3.1, 0777, 40.4, -5));
        double[] doubles = {4.5, 6.7, 0xf1};
        System.out.println(max(doubles));
    }

    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values) if (v > largest) largest = v;
        return largest;
    }
}
