package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class ProcessBuilderTest1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder
                .command("netstat")
//                .directory(new File("c:/000/"))
//                .redirectInput(Redirect.from(new File("/dev/null"))) // "NUL" for Windows
//                .redirectOutput(Redirect.PIPE)
                .redirectErrorStream(true);
        Process process = processBuilder.start();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        }
        int exitValue = process.waitFor();
        if (exitValue != 0) {
            System.err.println("Subprocess terminated abnormally");
        }
    }
}
