package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ReaderWriterTutor1 {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Записывает в файл FILES_TEST_PATH строку TEST_LINE, используя
     * метод write класса BufferedWriter.
     * Затем закрывает поток.
     */
    public void writeToFile() {
        try (BufferedWriter out =
                     new BufferedWriter(
                             new FileWriter(FILES_TEST_PATH))) {
            out.write(TEST_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Считывает строку из файла с помощью метода readLine()
     * класса BufferedReader и возвращает ее.
     * @return
     */
    public String readFromFile() {
        try {
            BufferedReader in =
                    new BufferedReader(
                            new FileReader(
                                    FILES_TEST_PATH));
            String line = in.readLine();
//            log(line);
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testStream() {
        writeToFile();
        String s = readFromFile();
        assertEquals(TEST_LINE, s);
    }

    @Before
    public void createFile() {
        File f1 = new File(FILES_TEST_PATH);
        try {
            f1.delete();
            f1.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
