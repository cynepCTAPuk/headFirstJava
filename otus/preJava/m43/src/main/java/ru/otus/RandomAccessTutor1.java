package ru.otus;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RandomAccessTutor1 {

    private static final String FILES_TEST_PATH = "files/test.txt";

    /**
     * Метод должен открывать файл RandomAccessFile
     * по пути FILES_TEST_PATH
     * и записывать туда число 10 (тип Integer),
     * а затем строку "test line"
     */
    public void randomAccessWrite() {
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "rw");
            f.writeInt(10);
            f.writeChars("test line");
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод должен открывать файл RandomAccessFile
     * по пути FILES_TEST_PATH,
     * пропускать число 10 и слово "test " (не считывая их),
     * прыгать на 5-ую букву, считывать и возвращать строку "line"
     */
    public String randomAccessRead() {
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "r");
            f.seek(14);
            String line = f.readLine();
            System.out.println(line);
//            log("read line:" + line);
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
    public void testRandomAccess() throws UnsupportedEncodingException {
        randomAccessWrite();
        String s = null;
        int i = -1;
        try {
            RandomAccessFile f = new RandomAccessFile(
                    FILES_TEST_PATH, "r");
            i = f.readInt();
            s = f.readLine();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(i, 10);
        s = new String(s.getBytes(
                "UTF-8"), "Unicode");
        assertEquals("test line", s);
        String read = randomAccessRead();
        String read1 = new String(read.getBytes(
                "UTF-8"), "Unicode");
        assertEquals("line", read1);
    }
}
