package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        String fileSeparator = System.getProperty("file.separator");

        String absoluteFilePath = "c:\\000" + fileSeparator
                + "new" + fileSeparator
                + "new" + fileSeparator
                + "file.txt";
        File file = new File(absoluteFilePath);
        try {
            if (!file.exists()) file.getParentFile().mkdirs();
            if (file.createNewFile()) System.out.println(absoluteFilePath + " File Created");
            else System.out.println("File " + absoluteFilePath + " already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
