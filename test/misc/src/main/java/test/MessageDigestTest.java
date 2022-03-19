package test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    public static void main(String[] args) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest("Hello, JM.".getBytes(StandardCharsets.UTF_8));
            for (byte b : digest) System.out.printf("%1x", b);
            System.out.println();
            for (byte b : digest) System.out.printf("%02x", b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
