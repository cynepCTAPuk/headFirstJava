package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RandomAccessUTFTutor1 {

    private static final String FILES_TEST_PATH = "files/test.txt";

    /**
     * Запишите в файл FILES_TEST_PATH 2 строки UTF:
     * "test line" и "test line 2"
     */
    public void randomAccessWriteUTF() {
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "rw");
            f.writeUTF("test line");
            f.writeUTF("test line 2");
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Перепрыгните ко 2-ой строке UTF, используя skip,
     * считайте и верните ее значение
     * @return
     */
    public String randomAccessReadUTF() {
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "r");
            f.seek(11);
            String line = f.readUTF();
            System.out.println(line);
//            log("read line:"+line);
            return line;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    public void testRandomAccessUTF() throws
            UnsupportedEncodingException {
        randomAccessWriteUTF();
        String s1 = null, s2 = null;
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "r");
            s1 = f.readUTF();
            s2 = f.readUTF();
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals("test line", s1);
        assertEquals("test line 2", s2);
        String read = randomAccessReadUTF();
        assertEquals("test line 2", read);
    }
}
