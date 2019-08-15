package chap03_Fundamental;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("Hi, " + name+"!");
    }
}
