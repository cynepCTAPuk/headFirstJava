package recursion;

import java.io.File;

public class PrintAllFiles {
    public static void main(String[] args) {
        printAllFiles(new File("c:/000"));
    }

    public static void printAllFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                printAllFiles(file);
            else
                System.out.println(file.getAbsolutePath());
        }
    }
}
