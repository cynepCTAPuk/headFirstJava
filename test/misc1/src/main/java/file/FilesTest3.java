package file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest3 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("c:/000/berns.txt"), StandardCharsets.UTF_8);
        List<String> result = new ArrayList<>();
        for (String s : lines) if (s.startsWith("Как")) result.add(s.toUpperCase());
        for (String s : result) System.out.println(s);
    }
}
