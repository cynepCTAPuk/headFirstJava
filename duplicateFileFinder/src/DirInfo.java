import java.io.*;
import java.util.*;

public class DirInfo {
    private static List<File> files = new ArrayList<>();
    private static List<File> dirs = new ArrayList<>();

    private static int compare(File f1, File f2) throws IOException {
        try (
                BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(f1));
                BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(f2))) {
            while (true) {
                int b1 = bis1.read();
                int b2 = bis2.read();
                if (b1 != b2) return b1 - b2;
                if (b1 == -1 & b2 == -1) return 0;
            }
        }
    }

    private static void getFiles(File f) {
        for (File file : f.listFiles()) {
            if (file.isHidden()) continue;
            if (file.isFile()) {
                files.add(file);
            }
            if (file.isDirectory()) {
                dirs.add(file);
                getFiles(file);
            }
        }
    }

    public static List<File> getAllFiles(File f) {
        List<File> files = new ArrayList<>();

        File[] files1 = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        File[] folders = f.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File folder : folders) {
            files.addAll(getAllFiles(folder));
        }
        files.addAll(Arrays.asList(files1));
        return files;
    }

    public static void main(String[] args) throws IOException {
        long t0 = System.currentTimeMillis();
        getFiles(new File("C:/000"));
//        List<File> files = getAllFiles(new File("C:/000"));
        TreeSet<File> ts = new TreeSet<>(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                try {
                    return DirInfo.compare(o1, o2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

/*
        for (File f : files) {
            if (!ts.contains(f)) {
                ts.add(f);
            } else {
                File old = ts.floor(f);
                System.out.printf("%s = \n\t%s (size: %,d)\n", f, old, old.length());
            }
        }
*/

        System.out.printf("%-9s: %,10d\n", "All Dirs", dirs.size());
        System.out.printf("%-9s: %,10d\n", "All Files", files.size());
        long t1 = System.currentTimeMillis();
        System.out.printf("Time(milliSeconds): %,d", t1 - t0);
    }
}
