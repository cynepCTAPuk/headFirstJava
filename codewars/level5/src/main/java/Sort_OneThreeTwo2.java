import java.util.Arrays;
import java.util.Comparator;

public class Sort_OneThreeTwo2 {
    private static String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static int[] sort(final int array[]) {
        return Arrays
                .stream(array)
                .boxed()
                .sorted(Comparator.comparing(Sort_OneThreeTwo2::toName))
                .map(String::valueOf)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static String toName(int i) {
        return i == 0 ? "zero" : toWords((i / 100) % 10, " hundred") + ((i / 100) % 10 != 0 ? " " : "") + toWords(i % 100);
    }

    private static String toWords(int i, String toAppend) {
        return toWords(i) + (i > 0 ? toAppend : "");
    }

    private static String toWords(int i) {
        return i > 19 ? TENS[i / 10] + (i / 10 != 0 ? " " : "") + UNITS[i % 10] : UNITS[i];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));

        System.out.println(Arrays.toString(sort(new int[]{8, 8, 9, 9, 10, 10})));
        System.out.println(Arrays.toString(sort(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(sort(new int[]{9, 99, 999})));
    }
}