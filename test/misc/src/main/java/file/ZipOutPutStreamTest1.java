package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest1 {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\000\\berns.txt";
        String zipFile = "C:\\000\\output.zip";

        FileInputStream fis = new FileInputStream(filename);
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        zos.setLevel(1); // 0-9
        ZipEntry entry = new ZipEntry("doc.txt");

        zos.putNextEntry(entry);
        byte[] buffer = new byte[fis.available()];        // считываем содержимое файла в массив byte
        fis.read(buffer);
        zos.write(buffer);        // добавляем содержимое к архиву
        zos.closeEntry();        // закрываем текущую запись для новой записи

        zos.close();
    }
}