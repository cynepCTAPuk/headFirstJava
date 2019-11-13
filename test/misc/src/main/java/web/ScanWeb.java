package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ScanWeb {
    public static void main(String[] args) throws IOException {
        InputStream is = new URL("https://www.rbc.ru").openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String s;
        while ((s = br.readLine()) != null) sb.append(s);
        System.out.println(sb.toString().replace("><",">\n<"));
    }
}
