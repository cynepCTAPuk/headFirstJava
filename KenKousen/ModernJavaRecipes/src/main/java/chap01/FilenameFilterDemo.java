package chap01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;

public class FilenameFilterDemo {
    public static void main(String[] args) {
        File directory = new File("./src/main/java/chap01");
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
//        System.out.println(Arrays.asList(names));

        String[] names1 = directory.list((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(names1));

//        Arrays.stream(directory.list()).forEach(System.out::println);

//        for (File file : new File("c://").listFiles()) System.out.print(file + " ");
    }
}
