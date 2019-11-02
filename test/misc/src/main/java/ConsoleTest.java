package com.example;

import java.io.Console;
// How to mask a password when input from the console
public class ConsoleTest {
    public static void main(String[] args) throws Exception {
//        Doesn't work in IDE
        Console console = System.console();
        String username = console.readLine("Username: ");
        String password = new String(console.readPassword("Password: "));
        System.out.println(username + "/" + password);
    }
}
