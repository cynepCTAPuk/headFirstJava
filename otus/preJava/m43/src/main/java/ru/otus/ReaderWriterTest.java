package ru.otus;

import java.io.*;

public class ReaderWriterTest {
    private static final String FILES_TEST_PATH = "files/text.txt";
    private static final String TEST_LINE = "text line";

    public static void main(String[] args) {
        ReaderWriterTest readerWriterTest = new ReaderWriterTest();
//        readerWriterTest.writeToFile();
        readerWriterTest.readFromFile();
    }

    public void writeToFile() {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter((FILES_TEST_PATH)))) {
            out.write(TEST_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() {
        try {
            BufferedReader in =
                    new BufferedReader(
                            new FileReader(FILES_TEST_PATH));
            String line = in.readLine();
            System.out.println(line);
            return in.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
