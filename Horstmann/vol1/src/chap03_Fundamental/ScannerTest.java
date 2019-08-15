package chap03_Fundamental;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws IOException {
/**
 Scanner in = new Scanner(System.in);
 System.out.println("What is your name?");
 String name = in.nextLine();
 System.out.println("Hi, " + name+"!");
 */
        File fileIn = new File("c:/000/tam.txt");
        File fileOut = new File("c:/000/tamtam.txt");
//        Scanner in = new Scanner(Path.of("c:/000/tam.txt"), StandardCharsets.UTF_8);
        Scanner in = new Scanner(fileIn, StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter(fileOut, StandardCharsets.UTF_8);

        int i = 0;
        while (in.hasNext()) {
            String str = String.format("%02d", ++i) + ": " + in.nextLine();
            System.out.println(str);
            out.println(str);
        }

        out.flush();
        in.close();
        out.close();
    }
}
