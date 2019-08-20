package chap04_Objects_Classes;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryLister {
    public static void main(String[] args) throws Exception {
        var dirName = ".";

        if (args == null || args.length < 1) System.err.println("Will list the current directory");
        else dirName = args[0];

        Files.walk(Paths.get(dirName)).forEach(System.out::println);
    }
}