import java.io.*;

public class ListFiles {
    public static void main(String[] args) {
        File dir = new File("c:/000/111");
        if (dir.exists()) {
            String[] files = dir.list();
            System.out.println(files.length + " файлов найдено...");
            for (String file : files) System.out.println(file);
        } else System.out.println("Каталог не найден.");
    }
}