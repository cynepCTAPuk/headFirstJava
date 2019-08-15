package chap03_Fundamental;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console cons = System.console();
        if (cons != null) {
            String username = cons.readLine("User name: ");
            char[] passwd = cons.readPassword("Password: ");
            System.out.println("Hi, " + username + "! Your password: " + new String(passwd));
        } else System.out.println("Run ConsoleTest from console!");
    }
}
