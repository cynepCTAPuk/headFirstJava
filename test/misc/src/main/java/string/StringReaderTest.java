package string;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public class StringReaderTest {
    public static void main(String[] args) throws Exception {
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";
        //это строчка – ключевая: мы «превратили» строку в Reader
        Reader reader = new StringReader(test);
        executor(reader);
    }

    private static void executor(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) System.out.println(line);
    }
}
