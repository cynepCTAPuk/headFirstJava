package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeTest1 {
    public static void main(String[] args) throws IOException {
        String command = "netstat";
        Runtime runtime = Runtime.getRuntime();
        System.out.printf("%,d%n", runtime.freeMemory());
        System.out.printf("%,d%n", runtime.totalMemory());

        Process process = runtime.exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
