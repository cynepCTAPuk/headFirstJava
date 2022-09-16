package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDirsByRecursion {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Path path = Paths.get(root);
        File file = path.toFile();
        if (file.isDirectory()) {
            File[] dir = file.listFiles();
            if (dir != null)
                for (File x : dir)
                    result.addAll(getFileTree(x.toString()));
        } else if (file.isFile() && file.exists())
            result.add(file.toString());
        return result;
    }

    public static void listFiles(String startDir) {
        File dir = new File(startDir);
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file.getAbsolutePath());
                } else {
                    System.out.println("\t" + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        List<String> list;
//        list = getFileTree("c:/000");
//        list.forEach(System.out::println);

//        listFiles("c:/000");

        try (Stream<Path> walk = Files.walk(Paths.get("c:/000"))) {
            // We want to find only regular files
            List<String> result = walk
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .collect(Collectors.toList());
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
