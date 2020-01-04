package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest {
    public static void main(String[] args) throws IOException {
        String fileName = "c:/000/berns.txt";

        String zipFile = "C:\\000\\output.zip";
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));   //создаем архив
        zos.setLevel(1); // 0-9
        ZipEntry entry = new ZipEntry("document.txt");

        zos.putNextEntry(entry);                   //кладем в архив zip «архивный объект» ZipEntry
        Files.copy(Paths.get(fileName), zos);     //копируем файл «berns.txt» в архив под именем «document.txt»
        zos.closeEntry();

        zos.close();                                //закрываем архив
    }
}
