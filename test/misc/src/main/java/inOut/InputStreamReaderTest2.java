package inOut;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest2 {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\username\\Desktop\\testFile.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    }
}
