package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderTest1 {
    public static void main(String[] args) throws IOException {
        File file = new File("c:/000/berns.txt");
        List list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        list.forEach(System.out::println);
    }
}
