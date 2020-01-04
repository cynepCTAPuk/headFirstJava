package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest {
    public static void main(String[] args) throws IOException {
        String zipFile = "C:\\000\\archive.zip";
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        String name;
        long size;
        while ((entry = zis.getNextEntry()) != null) {
            name = entry.getName(); // получим название файла
            size = entry.getSize();  // получим его размер в байтах
            System.out.printf("File name: %s \t File size: %d \n", name, size);

//            FileOutputStream fos = new FileOutputStream("C:\\000\\new_" + name);
//            for (int data = zis.read(); data != -1; data = zis.read()) fos.write(data);
            zis.closeEntry();
//            fos.close();
        }
        zis.close();
    }
}