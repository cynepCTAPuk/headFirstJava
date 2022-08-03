package chars;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class Encodings {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("d:/data.txt");
        FileOutputStream outputStream = new FileOutputStream("d:/data.txt");

        //список доступных кодировок
        SortedMap<String, Charset> charsets = Charset.availableCharsets();

        //узнать текущую кодировку
        Charset currentCharset = Charset.defaultCharset();

        String s = "Good news everyone!";
        //создать массив байт в любой известной Java кодировке
        byte[] buffer = s.getBytes("Windows-1251");

        byte[] fileBuffer = new byte[1000];
        inputStream.read(fileBuffer);
        //преобразовать набор байт, прочитанных из файла в строку
        String s1 = new String(fileBuffer, "Windows-1251");

        //преобразовать набор байт из одной кодировки в другую
        Charset koi8 = Charset.forName("KOI8-R");
        Charset windows1251 = Charset.forName("Windows-1251");
        byte[] buffer3 = new byte[1000];
        inputStream.read(buffer3);
        String s3 = new String(buffer3, koi8);
        buffer3 = s3.getBytes(windows1251);
        outputStream.write(buffer3);
    }
}