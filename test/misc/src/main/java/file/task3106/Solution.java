package file.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        List<String> list = new ArrayList<>(args.length - 1);
        list.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(list);

        Path tmpFile = Files.createTempFile("tmp", ".zip");
        byte[] buffer = new byte[1_024];
        int length = 0;

        FileOutputStream fos = new FileOutputStream(resultFileName, true);
        for (String str : list) {
            System.out.println(str);
            ZipInputStream zis = new ZipInputStream(new FileInputStream(str));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
//                System.out.println(entry);
                while ((length = zis.read(buffer)) > 0) {
                    System.out.println(length);
                    fos.write(buffer, 0, length);
                }
                zis.closeEntry();
            }
            zis.close();
        }
        fos.close();
    }
}
