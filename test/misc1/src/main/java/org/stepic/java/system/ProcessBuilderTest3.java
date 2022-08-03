package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderTest3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File("c:/000"));
        processBuilder.command("cmd", "/c", "start cmd.exe /K", "dir");

        Process process = processBuilder.start();

        int exitValue = process.waitFor();
        if (exitValue != 0) System.err.println("Subprocess terminated abnormally");
    }
}
