package chap03;

import java.util.*;

public class Coin {
    public static void main(String[] args) {
        Random random = new Random();
        int heads = 0, tails = 0;
        int maxHeads = 0, maxTails = 0;
        int prevMaxHeads = 0, prevMaxTails = 0;
        int coin;

        for (int i = 0; i < 200; i++) {
            if (i % 50 == 0) System.out.println();
            coin = random.nextInt(2);
            System.out.print(coin);

            if (coin == 0) {
                heads++;
                prevMaxHeads++;
                prevMaxTails = 0;
            }
            if (coin == 1) {
                tails++;
                prevMaxTails++;
                prevMaxHeads = 0;
            }

            if (prevMaxHeads > maxHeads) maxHeads = prevMaxHeads;
            if (prevMaxTails > maxTails) maxTails = prevMaxTails;
        }
        System.out.println();
        System.out.println("Heads = " + heads);
        System.out.println("Tails = " + tails);
        System.out.println("MaxHeads = " + maxHeads);
        System.out.println("MaxTails = " + maxTails);
    }
}
