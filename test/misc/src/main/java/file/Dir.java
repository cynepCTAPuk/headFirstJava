package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dir {
    public static void main(String[] args) throws IOException {
        File folder = new File("c:/000");
        List<String> list = new ArrayList<>();

        for (File file : folder.listFiles()) {
            list.add(file.getAbsolutePath());
            System.out.println((file.getAbsolutePath()));
        }
        System.out.printf("%,d\n", folder.getFreeSpace());
    }
}
