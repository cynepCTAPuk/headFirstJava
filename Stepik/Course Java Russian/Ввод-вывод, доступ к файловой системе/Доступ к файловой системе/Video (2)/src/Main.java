// You can experiment here, it won’t be checked

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class Task {
    public static void main(String[] args) {
        Path zipPath = Paths.get("C:/Program Files/Java/jdk1.8.0_221/src.zip");
        try (FileSystem zipfs = FileSystems.newFileSystem(zipPath, null)) {
            System.out.printf("%,d%n", Files.size(zipPath));
            final int[] i = {0};
            for (Path path : zipfs.getRootDirectories()) {
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println(file);
                        i[0]++;
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println(i[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
