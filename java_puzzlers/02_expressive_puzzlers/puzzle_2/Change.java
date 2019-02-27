package puzzle_2;

import java.math.*;

public class Change {
    public static void main(String args[]) {
        System.out.println(2.00 - 1.10);
        // Poor solution - still uses binary floating-point!
        System.out.printf("%.2f\n", 2.00 - 1.10);

        System.out.println((200 -110) + " cents");

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
