import java.util.Arrays;

public class Sort_OneThreeTwo {
    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static class Pair implements Comparable {
        Integer integer;
        String string;

        public Pair(Integer integer, String string) {
            this.integer = integer;
            this.string = string;
        }

        public Integer getInteger() {
            return integer;
        }

        @Override
        public String toString() {
            return string;
        }

        @Override
        public int compareTo(Object o) {
            return this.toString().compareTo(o.toString());
        }
    }

    private static String convertNumberToWord(final int n) {
        if (n < 20) return UNITS[n];
        if (n < 100) return TENS[n / 10] + ((n % 10 != 0) ? " " : "") + UNITS[n % 10];
        return UNITS[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + convertNumberToWord(n % 100);
    }

    public static int[] sort(final int[] array) {
        Pair[] pairs = new Pair[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) pairs[i] = new Pair(array[i], "zero");
            else pairs[i] = new Pair(array[i], convertNumberToWord(array[i]));
        }
        Arrays.sort(pairs);

        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++)
            ints[i] = pairs[i].getInteger();
        return ints;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));

        System.out.println(Arrays.toString(sort(new int[]{8, 8, 9, 9, 10, 10})));
        System.out.println(Arrays.toString(sort(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(sort(new int[]{9, 99, 999})));
    }
}