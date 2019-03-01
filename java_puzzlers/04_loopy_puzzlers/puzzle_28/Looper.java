package puzzle_28;

public class Looper {
    public static void main(String[] args) {
        // Place your declaration for i here
//        double i = 1.0 / 0.0;
//        double i = Double.POSITIVE_INFINITY;
        double i = 1.0e40;
        System.out.println(i);
        while (i == i + 1) {
        }
//        In summary, it is possible to represent infinity as a double or a float.
    }
}
