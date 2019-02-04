package chap12_exceptions;
import java.io.*;
public class PrintSelf {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("chap12_exceptions/PrintSelf.java"));
        String s;
        while ((s = in.readLine()) != null) { System.out.println(s); }
        in.close();
    }
}