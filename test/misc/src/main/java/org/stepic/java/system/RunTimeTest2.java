package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeTest2 {
    public static void main(String[] args) throws IOException {
        String command = "netstat"; // need reader
        command = "cmd /c cd \"C:\\000\" && dir && ver"; // need reader
        command = "cmd /c start notepad++.exe";
        command = "cmd /c start cmd.exe /K " + "cd \"C:\\000\"";

        Process process = Runtime.getRuntime().exec(command);
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
*/
    }
}
