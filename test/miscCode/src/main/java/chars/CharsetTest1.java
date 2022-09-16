package chars;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;

public class CharsetTest1 {
    public static void main(String[] args) {


    }

    void convert(InputStream inputStream, OutputStream outputStream) throws IOException {
        Charset koi8 = Charset.forName("KOI8-R");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1000];
        inputStream.read(buffer);
        String s = new String(buffer, koi8);
         buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
    }
}
