package in_out;

import java.io.*;

public class BufferedReaderTest1 {
    public static void main(String[] args) throws Exception {
        String test = "Hi!\n My name is Richard\n I'm a photographer\n";
        StringReader reader = new StringReader(test);

        StringWriter writer = new StringWriter();
        executor(reader, writer);
        String result = writer.toString();
        System.out.println("Результат: " + result);
    }

    public static void executor(Reader reader, Writer writer) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder(line);
            String newLine = sb.reverse().toString();
            writer.write(newLine);
        }
    }
}

