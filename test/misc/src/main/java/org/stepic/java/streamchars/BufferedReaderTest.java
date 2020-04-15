package org.stepic.java.streamchars;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new InputStreamReader(
                        new FileInputStream("in.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try (java.io.BufferedReader reader = Files.newBufferedReader(
                Paths.get("in.txt"), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        List<String> lines = Files.readAllLines(Paths.get("in.txt"), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }
}
