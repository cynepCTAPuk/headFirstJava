package org.stepic.java.functional;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FileFilterTest {
    public static void main(String[] args) {
        File directory = new File("c:/000");
        File[] javaSourceFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".java");
            }
        });
        Arrays.stream(javaSourceFiles).forEach(System.out::println);
    }
}
