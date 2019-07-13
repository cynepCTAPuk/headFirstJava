import java.util.Arrays;

public class OddOrEven {
    public static String oddOrEven(int[] array) {
        int result = Arrays.stream(array).sum();
        if (result == 0) return "zero";
        if (result % 2 == 1) return "odd";
        else return "even";
    }
}