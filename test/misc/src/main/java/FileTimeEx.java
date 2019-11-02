package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class FileTimeEx {
    public static void main(String[] args) throws IOException {
        FileTimeEx fileTimeEx = new FileTimeEx();
        fileTimeEx.proceed();
    }

    private void proceed() throws IOException {
        String pathToFile = "src/com.example.FileTimeEx.java";

        Path filePath = Paths.get(pathToFile);
        FileTime fileTime = Files.getLastModifiedTime(filePath);
        System.out.println("Timestamp of the file: " + fileTime.toString());
    }
}
