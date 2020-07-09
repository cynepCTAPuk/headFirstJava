package chap09_Package_Interface;

import java.util.Random;

public class Question implements SharedConstants {
    Random rand = new Random();

    int ask() {
        int prob = (int) (100 * rand.nextDouble());
        if (prob < 30) return NO; // 30%
        if (prob < 60) return YES; // 30%
        if (prob < 75) return LATER; // 15%
        if (prob < 98) return SOON; // 13%
        return NEVER; // 2%
    }
}
