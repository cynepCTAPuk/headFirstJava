package chap04;

import static java.lang.Math.pow;

public class VampireNumbers {

    public static void main(String[] args) {
        int dimension = 3;
        int begin = (int) pow(10, dimension - 1);
        int end = begin * 10 - begin;
        int[] numbers = new int[end];

        for (int i = 0; i < end; i++) numbers[i] = begin++;
        int qty = 0;
        int start = (int) pow(10, 2 * dimension - 1);
        int finish = start * 10 - start;

        for (int i = 0; i < finish; i++) {
            start++;
            if (start % 100 == 0) continue;

            String primary = String.valueOf(start);

            for (int j = 0; j < end; j++) {
                String divider1 = String.valueOf(numbers[j]);
                String primary1 = contain(primary, divider1);
                if (primary1 == null) continue;

                for (int k = 0; k < end; k++) {
                    String divider2 = String.valueOf(numbers[k]);
                    String primary2 = contain(primary1, divider2);
                    if (primary2 == null) continue;

                    if (start == (numbers[j] * numbers[k])) {
                        System.out.format("%,d = %,d*%,d\t", start, numbers[j], numbers[k]);
                        qty++;
                        if (qty % 2 == 0) System.out.println();
                    }
                }
            }
        }
        System.out.println("\nКол-во чисел = " + qty);
    }

    static String contain(String base, String part) {
        char[] chars = part.toCharArray();
        int i;
        for (i = 0; i < chars.length; i++) {
            if (!base.contains(String.valueOf(chars[i]))) break;
            else base = base.replaceFirst(String.valueOf(chars[i]), "x");
        }
        if (i == part.length()) return base;
        else return null;
    }
}
