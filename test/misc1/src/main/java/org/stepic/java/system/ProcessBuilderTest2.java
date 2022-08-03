package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "cd \"C:\" && dir");
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        br.lines().forEach(System.out::println);
        br.close();

        int exitValue = process.waitFor();
        if (exitValue != 0) System.err.println("Subprocess terminated abnormally");
    }
}
