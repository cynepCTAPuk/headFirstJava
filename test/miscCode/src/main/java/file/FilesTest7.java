package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FilesTest7 {
    public static void main(String[] args) throws IOException {
        Path path = Files.createTempFile("temp-", ".tmp");
        System.out.println(path);
        Files.deleteIfExists(path);

        File file = File.createTempFile("temp-", ".tmp");
        System.out.println(file);
        file.deleteOnExit();

        System.out.println(getExtensionByStringHandling("c:/000/1.txt"));
    }
    private static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

}