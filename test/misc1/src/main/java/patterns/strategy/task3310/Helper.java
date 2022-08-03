package patterns.strategy.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static void main(String[] args) {
        System.out.println(generateRandomString());
    }

    public static String generateRandomString() {
        return new BigInteger(64, new SecureRandom()).toString(36);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
