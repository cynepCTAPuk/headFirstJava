package chap03;

import java.util.*;

public class CoinFlip {
    public static void main(String[] args) {
        Random random = new Random();
        boolean coin;
        int heads = 0, tails = 0;
        int maxHeads = 0, maxTails = 0;
        int prevMaxHeads = 0, prevMaxTails = 0;

        for (int i = 0; i < 200; i++) {
            coin = random.nextBoolean();

            if (coin) {
                heads++;
                prevMaxHeads++;
                prevMaxTails = 0;
            }
            if (!coin) {
                tails++;
                prevMaxTails++;
                prevMaxHeads = 0;
            }

            if (prevMaxHeads > maxHeads) maxHeads = prevMaxHeads;
            if (prevMaxTails > maxTails) maxTails = prevMaxTails;
        }
        System.out.println("Heads = " + heads);
        System.out.println("Tails = " + tails);
        System.out.println("MaxHeads = " + maxHeads);
        System.out.println("MaxTails = " + maxTails);
    }
}
