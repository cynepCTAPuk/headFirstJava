package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest1 {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\000\\berns.txt";

        FileOutputStream fos = new FileOutputStream("C:\\000\\output.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream(filename);
        ZipEntry entry1 = new ZipEntry("berns.txt");
        zos.putNextEntry(entry1);
        byte[] buffer = new byte[fis.available()];        // считываем содержимое файла в массив byte
        fis.read(buffer);
        zos.write(buffer);        // добавляем содержимое к архиву
        zos.closeEntry();        // закрываем текущую запись для новой записи
        zos.close();
    }
}