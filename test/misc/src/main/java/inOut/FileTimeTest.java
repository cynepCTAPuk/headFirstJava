package inOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class FileTimeTest {
    public static void main(String[] args) throws IOException {
        FileTimeTest.proceed();
    }

    private static void proceed() throws IOException {
        Path path = Paths.get("src/main/java/inOut/FileTimeTest.java");

        FileTime lastModifiedTime = Files.getLastModifiedTime(path);

        System.out.println("Timestamp of the file: " + lastModifiedTime.toString());
    }
}
