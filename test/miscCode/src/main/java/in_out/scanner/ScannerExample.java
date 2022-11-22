package in_out.scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
    public static void makeFile(File file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("2 Java 1,5 true 1.6 ");
        }
    }

    public static void scanFile(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) System.out.println(scanner.nextInt() + " :int");
                else if (scanner.hasNextDouble()) System.out.println(scanner.nextDouble() + " :double");
                else if (scanner.hasNextBoolean()) System.out.println(scanner.nextBoolean() + " :boolean");
                else System.out.println(scanner.next() + " :String");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String folder = "c:/0/";
        String name = "ScannerExample.text";
        File file = new File(folder, name);
        ScannerExample.makeFile(file);
        ScannerExample.scanFile(file);
        System.out.println(file);
    }
}