package org.stepic.java.streamchars;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get("out.txt"), StandardCharsets.UTF_8)) {
            writer.write("Hello");
            writer.newLine();
        }

        List<String> lines = Arrays.asList("world","!");
        Files.write(Paths.get("out.txt"), lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
