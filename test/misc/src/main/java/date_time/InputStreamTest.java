package date_time;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream inStream = new FileInputStream("c:/000/source.txt");
        OutputStream outStream = new FileOutputStream("c:/000/destination.txt");

        while (inStream.available() > 0) {
            int data = inStream.read(); //читаем один байт из потока для чтения
            outStream.write(data); //записываем прочитанный байт в другой поток.
        }

        inStream.close(); //закрываем потоки
        outStream.close();
    }
}
