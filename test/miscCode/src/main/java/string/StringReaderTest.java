package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class StringReaderTest {
    public static void main(String[] args) {
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";
        //это строчка – ключевая: мы «превратили» строку в Reader
        Reader reader = new StringReader(test);
        executor(reader);
    }

    private static void executor(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        int i = 0;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(++i + ":\t" + line);
        }
    }
}
