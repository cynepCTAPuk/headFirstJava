package file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest1 {
    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(HOME);
        System.out.println(path);
    }
}
