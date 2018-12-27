package chap03;

import java.util.*;

public class CoinFlip {
    public static void main(String[] args) {
        Random random = new Random();
        boolean coin;
        int nol = 0, one = 0;
        int maxNol = 0, maxOne = 0;
        int prevMaxNol = 0, prevMaxOne = 0;

        for (int i = 0; i < 200; i++) {
            coin = random.nextBoolean();

            if (coin) {
                nol++;
                prevMaxNol++;
                prevMaxOne = 0;
            }
            if (!coin) {
                one++;
                prevMaxOne++;
                prevMaxNol = 0;
            }

            if (prevMaxNol > maxNol) maxNol = prevMaxNol;
            if (prevMaxOne > maxOne) maxOne = prevMaxOne;
        }
        System.out.println("Heads = " + nol);
        System.out.println("Tails = " + one);
        System.out.println("MaxHeads = " + maxNol);
        System.out.println("MaxTails = " + maxOne);
    }
}
