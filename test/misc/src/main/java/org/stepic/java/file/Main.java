package org.stepic.java.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String separator = File.separator;
        char separatorChar = File.separatorChar;
//        System.out.println(separator + " " + separatorChar);

        String pathSeparator = File.pathSeparator;
        char pathSeparatorChar = File.pathSeparatorChar;
//        System.out.println(pathSeparator + " " + pathSeparatorChar);

        Path srcDirectory = Paths.get("").toAbsolutePath();
//        System.out.println(srcDirectory);
//        System.out.println(Arrays.toString(srcDirectory.toFile().list()));

        Path userDir = Paths.get(System.getProperty("user.dir"));
//        System.out.println(userDir);

        Path path = Paths.get("src/main/java/"
                + Main.class.getPackage().getName().replace('.', '/')
                + "/Main.java");
        System.out.println(path);
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(7));

        System.out.println(Files.size(path));
        System.out.println(Files.getLastModifiedTime(path));

//        Files.lines(path).forEach(System.out::println);

//        File[] files = userDir.toFile().listFiles(f -> f.getName().endsWith(".png"));
//        Arrays.stream(files).forEach(System.out::println);
//        File[] dirs = userDir.toFile().listFiles(File::isDirectory);
//        Arrays.stream(dirs).forEach(System.out::println);

    }
}
