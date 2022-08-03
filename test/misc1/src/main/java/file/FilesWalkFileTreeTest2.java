package file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Информация о директории"
 */
public class FilesWalkFileTreeTest2 {
    public static void main(String[] args) throws IOException {
        String pathName = "c:/000";
        Path path = Paths.get(pathName);

        if (Files.isDirectory(path)) {
            MyFileVisitor2 myFileVisitor = new MyFileVisitor2();
            Files.walkFileTree(path, myFileVisitor);
            List<Path> folders = myFileVisitor.getFolders();
            List<Path> files = myFileVisitor.getFiles();
            int size = myFileVisitor.getSize() - 1;

            System.out.println("Всего папок - " + folders.size());
            System.out.println("Всего файлов - " + files.size());
            System.out.println("Общий размер - " + size);
        } else {
            System.out.println(path + " - не папка");
        }
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    private int size = 0;
    private List<Path> files = new ArrayList<>();
    private List<Path> folders = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public List<Path> getFiles() {
        return files;
    }

    public List<Path> getFolders() {
        return folders;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        this.files.add(path);
        this.size += Integer.parseInt(Files.getAttribute(path, "size").toString());
//        this.size += Files.readAllBytes(path).length;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        this.folders.add(path);
        return FileVisitResult.CONTINUE;
    }
}
