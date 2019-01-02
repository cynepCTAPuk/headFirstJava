package chap04;

public class VampireNumbers {
    static String primary;

    public static void main(String[] args) {
        int qty = 0;
        int start = 10;
        int[] numbers = new int[90];

        for (int i = 0; i < 90; i++) numbers[i] = start++;

        for (int i = 1_000; i < 1_010; i++) {
            if (i % 100 == 0) continue;
            primary = String.valueOf(i);
            char[] charsPrimary = primary.toCharArray();

            for (int j = 0; j < 90; j++) {
                String divider1 = String.valueOf(numbers[j]);
                char[] charsDivider1 = divider1.toCharArray();


                for (int k = 0; k < 90; k++) {
                    String divider2 = String.valueOf(numbers[k]);
                    char[] charsDivider2 = divider2.toCharArray();

                    if (i == (numbers[j] * numbers[k])) {
                        System.out.format("%,d = %,d * %,d\n", i, numbers[j], numbers[k]);
                        qty++;
                    }
                }
            }
//            System.out.println();
        }
        System.out.println("\nКол-во чисел = " + qty);
    }
}
