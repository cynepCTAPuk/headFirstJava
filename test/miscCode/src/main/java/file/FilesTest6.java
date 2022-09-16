package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FilesTest6 {
    public static void main(String[] args) throws IOException {
        String file = "c:/000/1.txt";
        Path path = Paths.get(file);
        System.out.println(path);
        Object object;

/*
        object = Files.getAttribute(path, "creationTime");
        System.out.println("Creation time: " + object);

        object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
        System.out.println("Last modified time: " + object);

        object = Files.getAttribute(path, "size");
        System.out.println("Size: " + object);

        object = Files.getAttribute(path, "isDirectory");
        System.out.println("isDirectory: " + object);
*/

        Map<String, Object> map = Files.readAttributes(path, "*");
        map.forEach((k, v) -> System.out.println(k + "\t" + v));


    }
}