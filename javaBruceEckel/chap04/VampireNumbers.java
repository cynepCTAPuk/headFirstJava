package chap04;

public class VampireNumbers {

    public static void main(String[] args) {
        int begin = 10;
        int[] numbers = new int[90];
        for (int i = 0; i < 90; i++) numbers[i] = begin++;

        int qty = 0;
        int start = 1_000;
        String primary;
        for (int i = 0; i < 9_000; i++) {
            start++;
            if (start % 100 == 0) continue;
            primary = String.valueOf(start);
            for (int j = 0; j < 90; j++) {
                String divider1 = String.valueOf(numbers[j]);
                if (contain(primary, divider1) == null) continue;
                else {
                    for (int k = 0; k < 90; k++) {
                        String divider2 = String.valueOf(numbers[k]);
                        if (contain(contain(primary, divider1), divider2) == null) {
                            continue;
                        } else {
                            if (start == (numbers[j] * numbers[k])) {
                                System.out.format("%,d = %,d*%,d %s\t|\t"
                                        , start, numbers[j], numbers[k], primary);
                                qty++;
                                if (qty % 3 == 0) System.out.println();
                            }
                        }
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
            else base = base.replace(chars[i], 'x');
        }
        if (i == part.length()) return base;
        else return null;
    }

/*
    static boolean contain(String base, String part) {
        char[] chars = part.toCharArray();
        int i;
        for (i = 0; i < chars.length; i++) {
            if (!base.contains(String.valueOf(chars[i]))) break;
            else {
                base = base.replace(chars[i], 'x');
            }
        }
        if (i == part.length()) {
            return true;
        } else return false;
    }

*/
}
