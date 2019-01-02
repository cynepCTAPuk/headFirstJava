package chap04;

public class VampireNumbers {

    public static void main(String[] args) {
        int qty = 0;
        int start = 10;
        int[] numbers = new int[90];
        for (int i = 0; i < 90; i++) numbers[i] = start++;

        for (int i = 1_000; i < 2_000; i++) {
            if (i % 100 == 0) continue;
            String primary = String.valueOf(i);

            for (int j = 0; j < 90; j++) {
                String divider1 = String.valueOf(numbers[j]);
                if (!contain(primary, divider1)) continue;
                else {
//                    primary = replace(primary, divider1);
                    for (int k = 0; k < 90; k++) {
                        String divider2 = String.valueOf(numbers[k]);
                        if (!contain(primary, divider2)) continue;
                        else {
                            if (i == (numbers[j] * numbers[k])) {
                                System.out.format("%,d = %,d * %,d %s\n"
                                        , i, numbers[j], numbers[k], primary);
                                qty++;
                            }
                        }
                    }
                }
            }
//            System.out.println();
        }
        System.out.println("\nКол-во чисел = " + qty);
    }

    static boolean contain(String base, String part) {
        char[] chars = part.toCharArray();
        int i;
        for (i = 0; i < chars.length; i++) {
            if (!base.contains(String.valueOf(chars[i]))) break;
            base = base.replace(chars[i], 'x');
        }
        if (i == part.length()) return true;
        else return false;
    }

    static String replace(String base, String part) {
        char[] chars = part.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            base = base.replace(chars[i], 'x');
        }
        return base;
    }
}
