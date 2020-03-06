package password;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator1 {
    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
//        System.out.println(generatePassword(8));
//        generatePassword1(8);

//        System.out.println(generatePassword2(8));
//        System.out.println(generatePassword3(8));

//        ByteArrayOutputStream password = getPassword();
//        System.out.println(password.toString());
//        ByteArrayOutputStream password1 = getPassword1();
//        System.out.println(password1.toString());
//        ByteArrayOutputStream password2 = getPassword2();
//        System.out.println(password2.toString());
//        System.out.println(generateRandomString(8));

        for (int i = 48; i < 123; i++) System.out.print(i + ":" + (char) i + " ");
    }

    private static char getSymbol() {
        int index = (int) (Math.random() * SYMBOLS.length());
        return SYMBOLS.charAt(index);
    }

    static String generatePassword(int len) {
        StringBuilder sb = new StringBuilder();
        while (len-- != 0) sb.append(getSymbol());
        return sb.toString();
    }

    static void generatePassword1(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(SYMBOLS.charAt(ThreadLocalRandom.current().nextInt(0, SYMBOLS.length())));
        }
        System.out.println();
    }

    static String generatePassword2(int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (; len > 0; --len) sb.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
        return sb.toString();
    }

    static String generatePassword3(int len) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < len; ++i) {
            char start = '0';
            int end = 10;

            switch (random.nextInt(3)) {
                case 0:
                    start = '0';
                    end = 10;
                    break;
                case 1:
                    start = 'a';
                    end = 26;
                    break;
                case 2:
                    start = 'A';
                    end = 26;
                    break;
            }
            password.append((char) (start + random.nextInt(end)));
        }

        return password.toString();
    }

    static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        Random random = new Random();
        // digits
        for (int i = 0; i < 2; i++) byteArrayOutputStream.write(48 + random.nextInt(10));
        // lower letters
        for (int i = 0; i < 3; i++) byteArrayOutputStream.write(65 + random.nextInt(26));
        // capital letters
        for (int i = 0; i < 3; i++) byteArrayOutputStream.write(97 + random.nextInt(26));

        return byteArrayOutputStream;
    }

    static ByteArrayOutputStream getPassword1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        Random random = new Random();
        int[] start = {48, 65, 97};
        int[] end = {58, 91, 123};
        for (int i = 0; i < 3; i++) {
            for (int j = start[i]; j < end[i]; j++) System.out.print((char) j);
//            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 2; i++) {
            byteArrayOutputStream.write(48 + random.nextInt(10));        // digits
            byteArrayOutputStream.write(65 + random.nextInt(26));        // lower letters
            byteArrayOutputStream.write(97 + random.nextInt(26));        // capital letters
        }

        return byteArrayOutputStream;
    }

    static ByteArrayOutputStream getPassword2() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        Random random = new Random();
        String set = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        byte[] bytes = new byte[8];

        bytes[0] = (byte) (48 + random.nextInt(10));
        bytes[1] = (byte) (65 + random.nextInt(26));
        bytes[2] = (byte) (97 + random.nextInt(26));
        for (int i = 3; i < 8; i++) bytes[i] = (byte) set.charAt(random.nextInt(set.length()));

        for (byte b : bytes) System.out.print((char) b);
        System.out.println();

        for (int i = bytes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            byte temp = bytes[j];
            bytes[j] = bytes[i];
            bytes[i] = temp;
        }

        byteArrayOutputStream.write(bytes);
        return byteArrayOutputStream;
    }

    static String generateRandomString(int len) {
        return new BigInteger(len * 5, new SecureRandom()).toString(36);
    }
}