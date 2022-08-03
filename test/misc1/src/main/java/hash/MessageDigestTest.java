package hash;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    public static void main(String... args) throws IOException, NoSuchAlgorithmException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject("test string");
        oos.flush();

        for (byte b : baos.toByteArray()) System.out.print((char)b);
        System.out.println();


        System.out.println(compareMD5(baos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
        System.out.println(MD5("test string"));
        System.out.println(getMD5("test string"));
    }

    public static boolean compareMD5(ByteArrayOutputStream baos, String md5) throws NoSuchAlgorithmException {
        byte[] data = baos.toByteArray();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(data);
//        byte[] digest = md.digest("test string".getBytes());

        for (byte b : digest) System.out.print(b);
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String s = Integer.toHexString(0xff & b);   // convert the byte to hex format
//            System.out.println(b + ":" + s);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }
        System.out.println(sb.toString());
        return md5.equals(sb.toString());
    }

    static String MD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(text.getBytes());

            for (byte b : digest) System.out.print(b);
            System.out.println();

            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    static String getMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset();
        md5.update(text.getBytes());
        byte[] digest = md5.digest();

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        // Now we need to zero pad it if you actually want the full 32 chars.
        while (md5Hex.length() < 32) md5Hex = "0" + md5Hex;
        return md5Hex;
    }
}
