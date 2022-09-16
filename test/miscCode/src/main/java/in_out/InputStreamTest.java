package in_out;

import java.io.*;
import java.util.Arrays;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("c:/000/1.txt");
        OutputStream os = new FileOutputStream("c:/000/2.txt");
        while (is.available() > 0) {
//            byte[] buffer = new byte[is.available()];
            byte[] buffer = new byte[1024];
            int i = is.read(buffer);
            os.write(buffer, 0, i);
            String str = new String(Arrays.copyOf(buffer, i));
            System.out.println(str);
        }

        os.close();
        is.close();

    }
}
