import java.util.Arrays;
public class Xbonacci {
    public double[] xbonacci(double[] signature, int n) {
        int length = signature.length;
        double[] result = new double[n];
        System.arraycopy(signature, 0, result, 0, length);
        for (int i = 0; i < n - length; i++)
            for (int j = i; j < i + length; j++)
                result[i + length] += result[j];
        return result;
    }

    public static void main(String[] args) {
        Xbonacci xb = new Xbonacci();
        System.out.println(Arrays.toString(xb.xbonacci(new double[]{0, 1}, 10)));
        System.out.println(Arrays.toString(xb.xbonacci(new double[]{1, 1}, 10)));
        System.out.println(Arrays.toString(xb.xbonacci(new double[]{0, 0, 0, 0, 1}, 10)));
        System.out.println(Arrays.toString(xb.xbonacci(new double[]{1, 0, 0, 0, 0, 0, 1}, 10)));
//        System.out.println(Arrays.toString(xb.xbonacci(new double[]{6.0, 8.0, 11.0, 13.0, 10.0, 20.0, 2.0, 19.0, 20.0, 3.0, 9.0, 20.0, 5.0, 13.0, 18.0, 10.0}, 17)));
//        System.out.println(Arrays.toString(xb.xbonacci(new double[]{16.0, 20.0, 4.0, 5.0, 15.0, 17.0, 19.0, 15.0, 8.0, 3.0, 8.0, 8.0, 15.0, 1.0, 12.0, 15.0}, 64)));
    }
}
//1.169394454204802E16