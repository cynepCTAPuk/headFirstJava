package file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Обход папки с выводом файлов и подпапок
 */
public class FilesWalkFileTreeTest3 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c:/000/");
//        MyFileVisitor3 myFileVisitor = new MyFileVisitor3();
//        Files.walkFileTree(path, myFileVisitor);
        Files.walkFileTree(path, new MyFileVisitor3());
    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        System.out.println("file name:" + path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        System.out.println("Directory name:" + path);
        return FileVisitResult.CONTINUE;
    }

}