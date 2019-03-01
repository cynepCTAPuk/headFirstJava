package puzzle_18;
/*
The lesson of this puzzle is that every time you translate a byte sequence to
a String, you are using a charset, whether you specify it explicitly or not. If
you want your program to behave predictably, specify a charset each time you use
one.
 */

import java.io.*;

public class StringCheese {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++)
            bytes[i] = (byte) i;
//        String str = new String(bytes);
        String str = new String(bytes, "ISO-8859-1");
        for (int i = 0, n = str.length(); i < n; i++)
            System.out.print((int) str.charAt(i) + " ");

        System.out.println();
        System.out.println(java.nio.charset.Charset.defaultCharset());
    }
}