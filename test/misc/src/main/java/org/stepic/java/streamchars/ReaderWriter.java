package org.stepic.java.streamchars;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReaderWriter {
    public static void main(String[] args) throws IOException {
        System.out.println(Charset.defaultCharset());

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        Reader reader = new InputStreamReader(inputStream, "UTF-8");
//        reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

        Charset charset = StandardCharsets.UTF_8;
        charset = StandardCharsets.US_ASCII;
        Writer writer = new OutputStreamWriter(outputStream, charset);

        int data;
        while ((data = reader.read()) != -1) {
            writer.write(data);
            writer.flush();
        }
    }
}
