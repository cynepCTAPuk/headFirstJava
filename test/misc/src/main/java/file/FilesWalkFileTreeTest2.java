package file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Найти файл содержащий строку "This is the file we need"
 */
public class FilesWalkFileTreeTest2 {
    public static void main(String[] args) throws IOException {
        MyFileVisitor2 myFileVisitor = new MyFileVisitor2();
        Files.walkFileTree(Paths.get("c:/000/"), myFileVisitor);
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    private int size;
    private List<Path> files = new ArrayList<>();
    private List<Path> folders = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(file)) {
            folders.add(file);
        } else {
            files.add(file);
            byte[] content = Files.readAllBytes(file); // размер файла: content.length
        }
        return FileVisitResult.CONTINUE;
    }
}
