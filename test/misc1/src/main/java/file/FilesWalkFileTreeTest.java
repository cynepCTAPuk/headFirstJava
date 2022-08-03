package file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Продвинутый поиск файлов
*/
public class FilesWalkFileTreeTest {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("c:/000/"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) System.out.println(file);
    }
}

class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (this.isCorrespondingFile(file, content)) this.foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    private boolean isCorrespondingFile(Path file, byte[] content) {
        return isValidPartOfName(file)
                && isValidPartOfContent(content)
                && isValidMinSize(content)
                && isValidMaxSize(content);
    }
    private boolean isValidPartOfName(Path file) {
        String fileName = file.getFileName().toString();
        return this.partOfName == null || fileName.contains(this.partOfName);
    }
    private boolean isValidPartOfContent(byte[] content) {
        String stringContent = new String(content);
        return this.partOfContent == null || stringContent.contains(this.partOfContent);
    }
    private boolean isValidMinSize(byte[] content) {
        return this.minSize == 0 || content.length > this.minSize;
    }
    private boolean isValidMaxSize(byte[] content) {
        return this.maxSize == 0 || content.length < this.maxSize;
    }
}
