package file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Найти файл содержащий строку "This is the file we need"
 */
public class FilesWalkFileTreeTest1 {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("c:/000/"), new MyFileVisitor1());
    }
}

class MyFileVisitor1 extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        try {
            List<String> lines = Files.readAllLines(file);
            for (String s : lines) {
                if (s.contains("This is the file we need")) {
                    System.out.println("Нужный файл обнаружен!");
                    System.out.println(file.toAbsolutePath());
//                    return FileVisitResult.TERMINATE; // если достаточно найти 1(один) файл
                }
            }
        } catch (IOException e) {
            System.out.print(e.toString() + " ");
            System.out.println(file.getFileName());
//            e.printStackTrace();
        }

//        return FileVisitResult.CONTINUE;
        return super.visitFile(file, attrs);
    }
}