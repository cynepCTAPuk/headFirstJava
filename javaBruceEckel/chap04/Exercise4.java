package chap04;

public class Exercise4 {
    public static void main(String[] args) {
        int max = 1_00;
        int count;
        int qty = 0;
        for (int i = 3; i < max; i += 2) {
            count = 0;
            for (int j = (i / 2); j > 1; j--) {
                if (i % j == 0) count++;
            }
            if (count == 0) {
                System.out.print(i + " ");
                qty++;
            }
        }
        System.out.println("\nQuantity Prime numbers " + qty);
    }
}
