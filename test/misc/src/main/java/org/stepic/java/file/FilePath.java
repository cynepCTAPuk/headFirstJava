package org.stepic.java.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FilePath {
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
                + FilePath.class.getPackage().getName().replace('.', '/')
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

/*
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(userDir, Main::dir)) {
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(userDir, Main::file)) {
            stream.forEach(System.out::println);
        }
*/
        System.out.println(Paths.get("a\\..\\b\\c\\file.txt").toFile().getCanonicalPath());
        System.out.println(Paths.get("a\\b\\..\\b\\c\\file.txt").toFile().getCanonicalPath());  // =
        System.out.println(Paths.get("a\\b\\..\\file.txt").toFile().getCanonicalPath());
        System.out.println(Paths.get("a\\b\\c\\file.txt").toFile().getCanonicalPath());         // =
        System.out.println(Paths.get("a\\.\\b\\..\\c\\.file.txt").toFile().getCanonicalPath());

    }

    private static boolean dir(Path f) {
        return Files.isDirectory(f);
    }

    private static boolean file(Path f) {
        return Files.isRegularFile(f);
    }
}
