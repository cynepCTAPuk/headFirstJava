package org.stepic.java.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderTest4 {
    public static void main(String[] args) throws IOException {
        String[] cmd = {"cmd", "/c", "start cmd.exe /K",
                "netstat -n | find \":3389\" | find \"ESTABLISHED\""};
        Process process = new ProcessBuilder().command(cmd).start();
    }
}
