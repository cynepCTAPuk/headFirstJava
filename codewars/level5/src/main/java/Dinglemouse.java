import java.util.Arrays;

public class Dinglemouse {
    private static final String[] units = {"", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};

    private static class Pair implements Comparable {
        String string;
        Integer integer;

        public Pair(String string, Integer integer) {
            this.string = string;
            this.integer = integer;
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
        if (n < 20) return units[n];
        if (n < 100) return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        return units[n / 100]
                + " hundred" + ((n % 100 != 0) ? " " : "") + convertNumberToWord(n % 100);
    }

    public static int[] sort(final int[] array) {
        Pair[] pairs = new Pair[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                pairs[i] = new Pair("zero", array[i]);
            } else pairs[i] = new Pair(convertNumberToWord(array[i]), array[i]);
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