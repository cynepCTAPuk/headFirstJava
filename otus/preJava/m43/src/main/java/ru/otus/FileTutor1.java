package ru.otus;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileTutor1 {
    private void createFile() {
        File dir = new File("test");
        dir.mkdir();
        File f = new File("test/test.txt");
/*
        try {
            log("Файл создан? " + f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
//        log(f.getAbsolutePath());
    }

    private void deleteFile() {
        File f = new File("test/test.txt");
        f.delete();
        File dir = new File("test");
        dir.delete();
    }

    @Test
    public void testCreateFile() {
        createFile();
        File f = new File("test/test.txt");
        Assert.assertTrue(f.exists());
    }

    @Test
    public void testDeleteFile() {
        deleteFile();
        File f = new File("test/test.txt");
        assertFalse(f.exists());
        assertFalse(new File("test").exists());
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(new File(".").getName());
//        System.out.println(new File(".").getAbsolutePath());
//        System.out.println(new File(".").getCanonicalPath());

        File dir = new File("dir");
        System.out.println(dir.exists());
        System.out.println(dir.mkdir());
        System.out.println(dir.getPath());

        System.out.println("-----------------");
        File subdir = new File(dir.getPath() + "/subdir");
        System.out.println(subdir.exists());
        System.out.println(subdir.mkdir());
        System.out.println(subdir.getPath());
        System.out.println(Arrays.asList(subdir.listFiles()).toString());

        System.out.println("-----------------");
        File file = new File(subdir.getPath() + "/file.txt");
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file.getPath());

        System.out.println(file.getParent());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getUsableSpace());

//        System.out.println(file.delete());
//        System.out.println(subdir.delete());
//        System.out.println(dir.delete());

        File root = new File(".");

        System.out.println("-----------------");
        String[] list = root.list(((d, name) -> !name.startsWith(".")));
        for (String s : list) System.out.println(s);

        System.out.println("-----------------");
        File[] listFiles = root.listFiles(f -> !f.isDirectory());
        for (File f : listFiles) System.out.println(f);
    }
}
