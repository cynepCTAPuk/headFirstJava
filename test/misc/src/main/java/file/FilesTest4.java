package file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesTest4 {
    public static void main(String[] args) throws IOException {
        Stream<String> stream = Files.lines(Paths.get("c:/000/berns.txt"), StandardCharsets.UTF_8);
        List<String> result = stream
                .filter(line -> line.startsWith("Как"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
