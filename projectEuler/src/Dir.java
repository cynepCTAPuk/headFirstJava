import java.io.File;

public class Dir {
    public static void main(String[] args) {
        printAllFiles(new File("c:/00"));
    }

    public static void printAllFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                printAllFiles(file);
            else {
                System.out.printf("%30s",file.getName() + ": ");
                System.out.printf("%,10d\n", file.length());
//                System.out.print(file.getAbsolutePath() + " ");
            }
        }
    }
}
