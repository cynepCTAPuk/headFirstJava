package Sorts;

import java.util.Random;

public class UtilsArray {
    static void fillRandom(int[] array) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) array[i] = rnd.nextInt(100);
    }
}
