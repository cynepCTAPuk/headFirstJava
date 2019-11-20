package inOut;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream("C:\\Users\\username\\Desktop\\testFile.txt"));
    }
}
