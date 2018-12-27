package chap03;

import java.util.*;

public class Coin {
    public static void main(String[] args) {
        Random random = new Random();
        int nol = 0, one = 0;
        int coin, prevCoin = 0;
        int maxNol = 0, maxOne = 0;
        int prevMaxNol = 0, prevMaxOne = 0;
        for (int i = 0; i < 200; i++) {
            if (i % 50 == 0) System.out.println();
            coin = random.nextInt(2);
            System.out.print(coin);

            if (coin == 0) {
                nol++;
                prevMaxNol++;
                prevMaxOne = 0;
            }
            if (coin == 1) {
                one++;
                prevMaxOne++;
                prevMaxNol = 0;
            }

            if (prevMaxNol > maxNol) maxNol = prevMaxNol;
            if (prevMaxOne > maxOne) maxOne = prevMaxOne;
        }
        System.out.println();
        System.out.println("Heads = " + nol);
        System.out.println("Tails = " + one);
        System.out.println("MaxHeads = " + maxNol);
        System.out.println("MaxTails = " + maxOne);
    }
}
