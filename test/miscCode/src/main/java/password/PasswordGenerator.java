package password;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        Random random = new Random();
//        String set = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int length = 8;                // length password
        byte[] bytes = new byte[length];

        bytes[0] = (byte) (48 + random.nextInt(10)); //digit
        bytes[1] = (byte) (65 + random.nextInt(26)); //capital letter
        bytes[2] = (byte) (97 + random.nextInt(26)); //lower letter
//        for (int i = 3; i < bytes.length; i++) bytes[i] = (byte) set.charAt(random.nextInt(set.length()));

        int a, b = 0;
        for (int i = 3; i < bytes.length; i++) {
            a = random.nextInt(10 + 26 + 26);
            if (a < 10) b = 48 + a;
            else if (a < (10 + 26)) b = 65 + a - 10;
            else if (a < (10 + 26 + 26)) b = 97 + a - 10 - 26;
            bytes[i] = (byte) b;
        }


        for (int i = bytes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            byte temp = bytes[j];
            bytes[j] = bytes[i];
            bytes[i] = temp;
        }

        try {
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}