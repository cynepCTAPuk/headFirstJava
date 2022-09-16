package in_out;

import java.io.IOException;

public class SystemInTest {
    public static void main(String[] args) throws IOException {
        while (true) {
            int x = System.in.read();
            System.out.println(x);
            // символ 10 - перенос строки
        }
    }
}
