package puzzle_29;

public class BrideOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
        // Any floating-point operation evaluates to NaN if one or more of its operands are NaN.
//        double i = 0.00/0.00;
        double i = Double.NaN;
        while (i != i) {
            System.out.println("Got it!");
            break;
        }
    }
}
