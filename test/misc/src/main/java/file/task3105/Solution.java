package file.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("addToArchive file archive");
            return;
        }
        String arg0 = args[0];
        String archive = args[1];
        File file = new File(arg0);
        ZipInputStream zis = new ZipInputStream(new FileInputStream(archive));

        HashMap<ZipEntry, ByteArrayOutputStream> hashMap = new HashMap<>();
        ZipEntry zipEntry;
        int length;
        while ((zipEntry = zis.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            while ((length = zis.read(bytes)) != -1) byteArrayOutputStream.write(bytes, 0, length);
            hashMap.put(zipEntry, byteArrayOutputStream);
            zis.closeEntry();
        }
        zis.close();

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(archive));
        String newFile = "new/" + file.getName();
        zos.putNextEntry(new ZipEntry(newFile));
        Files.copy(file.toPath(), zos);
        zos.closeEntry();

        for (Map.Entry<ZipEntry, ByteArrayOutputStream> entry : hashMap.entrySet()) {
            if (entry.getKey().getName().compareToIgnoreCase(newFile) != 0) {
                zos.putNextEntry(new ZipEntry(entry.getKey().getName()));
                zos.write(entry.getValue().toByteArray());
                zos.closeEntry();
            }
        }
        zos.close();
    }
}