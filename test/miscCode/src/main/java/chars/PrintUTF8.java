package chars;
// https://docs.oracle.com/javase/tutorial/i18n/text/string.html

import java.io.UnsupportedEncodingException;

public class PrintUTF8 {
    public static void main(String[] args) {
        String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");
        System.out.println(original);
        try {
            byte[] utf8Bytes = original.getBytes("UTF8");
            byte[] defaultBytes = original.getBytes();

            String roundTrip = new String(utf8Bytes, "UTF8");
            System.out.println("roundTrip = " + roundTrip);
            System.out.println();
            printBytes(utf8Bytes, "utf8Bytes");
            System.out.println();
            printBytes(defaultBytes, "defaultBytes");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" + UnicodeFormatter.byteToHex(array[k]));
        }
    }
}

class UnicodeFormatter {

    static public String byteToHex(byte b) {
        // Returns hex String representation of byte b
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] array = {hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f]};
        return new String(array);
    }

    static public String charToHex(char c) {
        // Returns hex String representation of char c
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
        return byteToHex(hi) + byteToHex(lo);
    }
}