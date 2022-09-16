package operations;

import java.util.Random;

public class ternaryOp {
    public static void main(String[] args) {
        Random random = new Random();
        int aa = 0;
        int bb = 0;
        int cc = 0;
        int cycle = 1_000;
        for (int i = 0; i < cycle; i++) {
            int r1 = random.nextInt();
            int r2 = random.nextInt();
            int a = Math.abs(r1 == Integer.MIN_VALUE ? 0 : Math.abs(r1));
            int b = Math.abs(r1 == Integer.MIN_VALUE ? 0 : Math.abs(r2));
            if (a > b) aa++;
            else if (b > a) bb++;
            else cc++;
        }
        System.out.println("a > b " + aa);
        System.out.println("b > a " + bb);
        System.out.println("a = a " + cc);
        System.out.println(
                aa > bb
                        ? "a > b " + (double) (aa - bb) * 100 / cycle + " %"
                        : "b > a " + (double) (bb - aa) * 100 / cycle + " %"
        );
    }
}
