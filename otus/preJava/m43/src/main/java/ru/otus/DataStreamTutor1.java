package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class DataStreamTutor1 {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Записывает в файл FILES_TEST_PATH строку TEST_LINE, используя
     * метод writeUTF класса DataOutputStream.
     * Также использует BufferedOutputStream для буферизации.
     * Затем закрывает поток.
     */
    public void writeToFile() {
        try (DataOutputStream out =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(
                                             FILES_TEST_PATH)))) {
            out.writeUTF(TEST_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Считывает строку из файла с помощью метода readUTF
     * и возвращает ее.
     *
     * @return
     */
    public String readFromFile() {
        try {
            DataInputStream in =
                    new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(
                                            FILES_TEST_PATH)));
            return in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    @Test
    public void testStream() {
        writeToFile();
        String s = readFromFile();
        assertEquals(TEST_LINE, s);
    }
}
