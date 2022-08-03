package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String command = "netstat";
        Process process = Runtime.getRuntime().exec(command);
        System.out.println(process.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println("The inout stream is " + s);
        }
    }
}
