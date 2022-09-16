package chars;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
/*
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry e : charsets.entrySet()) {
            if(e.getKey().toString().contains("UTF"))
            System.out.println(e.getKey() + ":" + e.getValue());
        }
*/
        Charset currentCharset = Charset.defaultCharset();
        System.out.println(currentCharset);

        String s = "Хорошие новости!";
        byte[] buffer = s.getBytes();
        System.out.println(Arrays.toString(buffer));

        String out = new String(buffer);
        System.out.println(out);

        Charset koi8 = Charset.forName("KOI8-R");
        byte[] buffer1 = s.getBytes(koi8);
        System.out.println(Arrays.toString(buffer1));
        out = new String(buffer1, koi8);
        System.out.println(out);

        byte[] buffer2 = s.getBytes("Windows-1251");
        System.out.println(Arrays.toString(buffer2));
        out = new String(buffer2, "Windows-1251");
        System.out.println(out);

        int[] ss = {1, 2};
        System.out.println("\nРазмер массива: " + ss.length);
    }
}
