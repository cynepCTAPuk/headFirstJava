package chap03;

import java.util.*;

public class RandomSeed {
    public static void main(String[] args) {
        Random random = new Random(50);
        for (int i = 0; i < 150; i++) {
            if (i % 30 == 0) System.out.println();
            System.out.print(random.nextInt(89) + 10 + " ");
        }
    }
}
