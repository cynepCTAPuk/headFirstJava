import java.io.*;
import java.util.*;

public class TreeInfo {
    static Set<File> files = new TreeSet<>();
    static Set<File> dirs = new TreeSet<>();

    static boolean compare(File f1, File f2) throws IOException {
        if (f1.length() != f2.length()) return false;
        try (
                BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(f1));
                BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(f2))) {
            while (true) {
                int b1 = bis1.read();
                int b2 = bis2.read();
                if (b1 != b2) return false;
                if (b1 == -1 & b2 == -1) return true;
            }
        }
    }

    static void getAllFiles(File f) {
        getAllFiles(f, ".*");
    }

    static void getAllFiles(File f, String regex) {
        for (File file : f.listFiles()) {
            if (file.isHidden()) continue;
            if (file.isDirectory()) {
                dirs.add(file);
                getAllFiles(file);
            } else {
                if (file.getName().matches(regex)) files.add(file);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File folder = new File("c:/000/pics");
        String regex = "jpg";
        getAllFiles(folder, regex);
        System.out.println();
        System.out.println(dirs);
        System.out.println(files);
        System.out.println("Dirs: " + dirs.size());
        System.out.println("Files: " + files.size());
/*
        for (int i = 0; i < allFiles.size(); i++) {
            if (allFiles.get(i).isDirectory()) continue;
            for (int j = i + 1; j < allFiles.size(); j++) {
                if (compare(allFiles.get(i), allFiles.get(j))) {
                    System.out.println(allFiles.get(i) + " = " + allFiles.get(j));
                }
            }
        }
*/
/*
        File f1 = new File("c:/000/data.txt");
        File f2 = new File("c:/000/data1.txt");
        boolean result = compare(f1, f2);
        System.out.println(result);
*/

    }
}
