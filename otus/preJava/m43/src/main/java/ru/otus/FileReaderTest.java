package ru.otus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileReaderTest {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("m43.iml");
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            String s;
            while ((s = lineNumberReader.readLine()) != null) {
                System.out.println(lineNumberReader.getLineNumber()
                        + "\t:\t" + s);
            }
            lineNumberReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
