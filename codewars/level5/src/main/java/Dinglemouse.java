import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Dinglemouse {
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};

    private static String convertNumberToWord(final int n) {
        if (n < 20) return units[n];
        if (n < 100) return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        return units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + convertNumberToWord(n % 100);
    }

    public static int[] sort(final int[] array) {
        Map<String, Integer> map = new TreeMap<>();
        for (int value : array) map.put(convertNumberToWord(value), value);
        int i = 0;
        int[] ints = new int[array.length];
        for (Integer integer : map.values()) ints[i++] = integer;
        return ints;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }
}