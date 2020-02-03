package patterns.strategy.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException ignored) {
        }
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0;
        }
    }

    public void putEntry(Entry entry) {
        try {
            new ObjectOutputStream(Files.newOutputStream(path)).writeObject(entry);
        } catch (IOException ignored) {
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try {
            return (Entry) new ObjectInputStream(Files.newInputStream(path)).readObject();
        } catch (IOException | ClassNotFoundException ignored) {
            return null;
        }
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException ignored) {
        }
    }
}
