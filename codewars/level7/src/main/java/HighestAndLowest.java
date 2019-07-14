import java.util.Arrays;

public class HighestAndLowest {
    public static String HighAndLow(String numbers) {
        String[] strings = numbers.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) ints[i] = Integer.valueOf(strings[i]);

        Arrays.sort(ints);
        return ints[ints.length - 1] + " " + ints[0];
    }
}