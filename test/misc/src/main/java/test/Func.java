package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Func {
    public static void main(String[] args) {
        String file = "-";
        try {
            file = Files.readString(Path.of("c:\\0\\Test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file);
    }
}
