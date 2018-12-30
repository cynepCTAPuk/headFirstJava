package chap04;

public class Exercise4 {
    public static void main(String[] args) {
        int max = 1_000;
        int count;
        int qty = 1;
        System.out.format("%,d ", 2);
        for (int i = 3; i < max; i += 2) {
            count = 0;
            for (int j = 2; j < (i / 2); j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.format("%,d ", i);
                qty++;
            }
        }
        System.out.println("\nPrime numbers quantity " + qty);
    }
}
