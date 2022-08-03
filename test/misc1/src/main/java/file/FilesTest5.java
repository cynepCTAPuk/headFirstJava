package file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesTest5 {
    public static void main(String[] args) throws IOException {
        String file = "c:/000/1.txt";
        Path path = Paths.get(file);

        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file/directory " + path.getFileName());
            if (Files.isDirectory(path))
                System.out.println(path.getFileName() + " is a directory");
            else
                System.out.println(path.getFileName() + " is a file");
        } else
            System.out.println("The file/directory " + path.getFileName() + " does not exist");

        System.out.printf("Readable: %b, Writable: %b, Executable: %b ",
                Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
    }
}
