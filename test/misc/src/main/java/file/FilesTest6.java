package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTest6 {
    public static void main(String[] args) throws IOException {
        String file = "c:/000/";
        Path path = Paths.get(file);
        Object object;

        object = Files.getAttribute(path, "creationTime");
        System.out.println("Creation time: " + object);

        object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
        System.out.println("Last modified time: " + object);

        object = Files.getAttribute(path, "size");
        System.out.println("Size: " + object);

        object = Files.getAttribute(path, "isDirectory");
        System.out.println("isDirectory: " + object);

    }
}