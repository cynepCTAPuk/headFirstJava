package in_out;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        while (true) {
            int x = reader.read();
            System.out.println(x);
        }
    }
}
