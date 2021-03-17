package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsTest20 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\000\\test.txt"));
        String firstString = reader.readLine();
        System.out.println(firstString);
    }
}
