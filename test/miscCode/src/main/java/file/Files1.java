package file;

import java.io.File;
import java.io.IOException;

public class Files1 {
    public static void main(String[] args) throws IOException {
        File file = new File("/000");
        File[] files = file.listFiles();
        System.out.println(file.getPath());
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) System.out.println(f.getCanonicalPath());
            }
        }
    }
}
