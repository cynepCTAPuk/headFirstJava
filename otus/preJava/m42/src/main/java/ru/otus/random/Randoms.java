package ru.otus.random;

import java.util.Random;

public class Randoms {
    public static void main(String[] args) {
        Random randomD = new Random();
        Random randomI = new Random();
        for (int i = 0; i < 10; i++) {
            double ranD = randomD.nextDouble();
            int ranI = randomI.nextInt();
            System.out.println(ranD + "\t\t" + ranI);
        }
    }
}
